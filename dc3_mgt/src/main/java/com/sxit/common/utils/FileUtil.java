package com.sxit.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

import com.sxit.common.entity.TuplFiles;

/**
 * 文件(图片)上传帮助类
 * @author lifodai
 * @date 2015-03-20
 */
public class FileUtil {
	
	private static final Log LOG = LogFactory.getLog(FileUtil.class);
	
	private static final String UPLOADPATH = "uploadFile" ;
	
	/**
	 * 图片默认存在指定路径
	 * @param file MultipartFile
	 * @param realPath 站点路径
	 * @param module 模块
	 * @return
	 */
	public static TuplFiles uploadImage(MultipartFile file, String realPath, String module) {
		if(module == null) module = "" ;
		//相对站点文件存在路径
		String path = new StringBuffer(UPLOADPATH).append(File.separator)
				.append("images").append(File.separator)
				.append(module).toString() ;
		return upload(file, realPath, path) ;
	}
	
	/**
	 * 文件默认存在指定路径
	 * @param file MultipartFile
	 * @param realPath 站点路径
	 * @param module 模块
	 * @return
	 */
	public static TuplFiles uploadFile(MultipartFile file, String realPath, String module) {
		//相对站点文件存在路径
		if(module == null) module = "" ;
		String path = new StringBuffer(UPLOADPATH).append(File.separator)
				.append("file").append(File.separator)
				.append(module).toString() ;
		return upload(file, realPath, path) ;
	}

	/**
	 * 将文件存储到指定目录下 文件为了安全存储到WebInf下面 上传文件
	 * @param file MultipartFile
	 * @param realPath 文件上传的路径
	 * @param module 模块名称
	 * @return
	 */
	public static TuplFiles upload(MultipartFile file, String realPath, String path) {

		// 去除相对路径 /
		if (path.startsWith("/") || path.startsWith("\\")) path = path.substring(1);
		if (path.endsWith("/") || path.endsWith("\\")) path = path.substring(0, path.length() - 1);
		
		// 上传的根路径
		String uploadPath = new StringBuffer(realPath)
				.append(File.separator).append(path).toString();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMM");
		String datepath = dateFormat.format(new Date());

		String upFileName = file.getOriginalFilename();

		// 扩展名
		String extName = "";
		int i = upFileName.lastIndexOf(".");
		if (i > 0) {
			extName = upFileName.substring(i + 1);
		}

		int max = 99999;
		int min = 10000;
		int r = new Random().nextInt(max - min) + min;
		long now = System.currentTimeMillis();

		// 文件名
		String fileName = new StringBuffer().append(now).append(r)
					.append(".").append(extName).toString();

		fileName = fileName.substring(4);

		// 上传文件的路径
		realPath = uploadPath + File.separator + datepath
				+ File.separator;

		// 判断目录是否存在

		File real = new File(realPath);
		if (!real.exists() || !real.isDirectory()) {
			real.mkdirs();
		}

		File dest = new File(realPath + fileName);

		try {
			file.transferTo(dest);
		} catch (IOException e) {
			e.printStackTrace();
			LOG.error("上传文件移动失败", e);
		}
		String webPath = new StringBuffer("/").append(path).append("/").append(datepath)
				.append("/").append(fileName).toString();
		TuplFiles uplog = new TuplFiles(fileName, file.getOriginalFilename(), webPath, file.getSize(), extName) ;
		return uplog;
	}

	/**
	 * 删除文件
	 * @param filepath 文件绝对路径
	 * @return true:删除成功  false:删除失败
	 */
	public static boolean delete(String filepath) {
		if (filepath != null) {
			filepath = filepath.replace("/", "\\");
			File file = new File(filepath);
			if (file.exists()) {
				file.delete();
				return true; 
			}
		}
		return false; 
	}

	/**
	 * 上传压缩文件 并解压
	 * @param upload
	 * @param root
	 * @param path
	 * @param savename
	 * @return
	 */
	public static String uploadZip(File upload, String root, String path,
			String savename) {
		String uploadRootPath = root;
		if (path.startsWith("/")) {
			path = path.substring(1);
		}
		String filePath = (new StringBuilder(String.valueOf(uploadRootPath)))
				.append(File.separator)
				.append(path.replace("/", File.separator)).toString();
		LOG.debug((new StringBuilder("uploadRootPath:")).append(uploadRootPath)
				.append(",filePath:").append(filePath).toString());
		File file = new File(filePath);
		if (!file.exists() || !file.isDirectory()) {
			boolean b = file.mkdirs();
			if (!b) {
				try {
					FileUtils.forceMkdir(file);
				} catch (IOException ioe) {
					LOG.error("commons-io创建目录失败", ioe);
				}
			}
		}
		String filename = upload.getName().replaceAll("\\.tmp", "");
		if (savename != null && !"".equals(savename.trim())) {
			filename = savename;
		}
		File dest = new File((new StringBuilder(String.valueOf(filePath)))
				.append(File.separator).append(filename).toString());
		boolean b = upload.renameTo(dest);
		if (!b) {
			try {
				FileUtils.copyFile(upload, dest);
				FileUtils.forceDelete(upload);
				LOG.debug("上传文件移动到"
						+ (filePath + java.io.File.separator + filename) + "成功");
			} catch (IOException ioe) {
				LOG.error("上传文件移动失败", ioe);
			}
		}
		String zipfilePath = (new StringBuilder(String.valueOf(filePath)))
				.append(File.separator)
				.append(filename.replaceAll("/", "\\\\")).toString();
		unzipFile(filePath, zipfilePath);
		return (path + filename);
	}

	/**
	 * 解压文件
	 * @param targetPath 存放目标目录
	 * @param zipFilePath 压缩文件路径
	 */
	public static void unzipFile(String targetPath, String zipFilePath) {
		try {

			File zipFile = new File(zipFilePath);
			InputStream is = new FileInputStream(zipFile);
			ZipInputStream zis = new ZipInputStream(is);
			ZipEntry entry = null;

			while ((entry = zis.getNextEntry()) != null) {
				String zipPath = entry.getName();
				if (entry.isDirectory()) {
					File zipFolder = new File(targetPath + File.separator
							+ zipPath);
					if (!zipFolder.exists()) {
						zipFolder.mkdirs();
					}
				} else {
					File file = new File(targetPath + File.separator + zipPath);
					if (!file.exists()) {
						File pathDir = file.getParentFile();
						pathDir.mkdirs();
						file.createNewFile();
					}
					FileOutputStream fos = new FileOutputStream(file);
					int bread;
					while ((bread = zis.read()) != -1) {
						fos.write(bread);
					}
					fos.close();
				}
			}
			zis.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}