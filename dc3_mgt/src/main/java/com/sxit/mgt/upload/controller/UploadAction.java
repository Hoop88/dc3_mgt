package com.sxit.mgt.upload.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sxit.common.action.BaseAction;
import com.sxit.common.dto.ResultMessage;
import com.sxit.common.entity.TuplFiles;
import com.sxit.common.utils.FileUtil;
import com.sxit.mgt.upload.vo.UploadRes;

@Controller
@RequestMapping(value = "/upload")
public class UploadAction extends BaseAction {
	
	/**
	 * 上传图片
	 */
	@RequestMapping(value = "/uploadPic")
	public @ResponseBody
	UploadRes uploadPic(@RequestParam MultipartFile filedata, String module) {

		String realPath = getHttpSession().getServletContext().getRealPath("/");

		UploadRes res = new UploadRes();
		if (!filedata.isEmpty()) {
			TuplFiles upfile = FileUtil.uploadImage(filedata, realPath, module);
			res = new UploadRes(UploadRes.SUCESS,
					upfile.getOriginalName(), upfile.getPath());
		} 
		return res;
	}

	/**
	 * 上传文件
	 * 
	 * @param filedata
	 * @param path
	 * @return
	 */
	@RequestMapping(value = "/uploadFile")
	public @ResponseBody
	UploadRes uploadFile(@RequestParam MultipartFile filedata, String module) {


		String realPath = getHttpSession().getServletContext().getRealPath("/");

		UploadRes res = new UploadRes();
		if (!filedata.isEmpty()) {
			TuplFiles upfile = FileUtil.uploadFile(filedata, realPath, module);
			String urlstr = this.getCururl();
			urlstr = urlstr.substring(0, urlstr.lastIndexOf("/"));

			res = new UploadRes(UploadRes.SUCESS, upfile.getOriginalName(), upfile.getPath());
		}
		return res;
	}

	/**
	 * 下载文件
	 * 
	 * @param res
	 * @param id
	 * @param model
	 * @return
	 * @throws IOException
	 */
	/*@RequestMapping("/download")
	public String download(HttpServletResponse res, String path, ModelMap model)
			throws IOException {
		String message = "下载成功";

		String realPath = getHttpSession().getServletContext().getRealPath("/");
		String filePath = realPath + path ;
		File file = new File(filePath);

		if (!file.exists()) {
			message = "下载出错:文件不存在";
			model.addAttribute("message", message);
			return "common/message";
		} else {

			String new_filename = URLEncoder.encode(filename, "UTF-8");
			// 如果没有UA，则默认使用IE的方式进行编码，因为毕竟IE还是占多数的
			String rtn = "filename=\"" + new_filename + "\"";

			String userAgent = getRequest().getHeader("user-agent");

			if (userAgent != null) {
				userAgent = userAgent.toLowerCase();
				// IE浏览器，只能采用URLEncoder编码
				if (userAgent.indexOf("msie") != -1) {
					rtn = "filename=\"" + new_filename + "\"";
				}
				// Opera浏览器只能采用filename*
				else if (userAgent.indexOf("opera") != -1) {
					rtn = "filename*=UTF-8''" + new_filename;
				}
				// Safari浏览器，只能采用ISO编码的中文输出
				else if (userAgent.indexOf("safari") != -1) {
					rtn = "filename=\""
							+ new String(filename.getBytes("UTF-8"),
									"ISO8859-1") + "\"";
				}
				// Chrome浏览器，只能采用MimeUtility编码或ISO编码的中文输出
				else if (userAgent.indexOf("applewebkit") != -1) {
					new_filename = MimeUtility.encodeText(filename, "UTF8",
							"B");
					rtn = "filename=\"" + new_filename + "\"";
				}
				// FireFox浏览器，可以使用MimeUtility或filename*或ISO编码的中文输出
				else if (userAgent.indexOf("mozilla") != -1) {
					rtn = "filename*=UTF-8''" + new_filename;
				}
			}
			
			OutputStream os = res.getOutputStream();
			try {
				res.reset();
				res.setHeader("Content-Disposition", "attachment;" + rtn);
				res.setContentType("application/octet-stream; charset=utf-8");
				os.write(FileUtils.readFileToByteArray(file));
				os.flush();
			} finally {
				if (os != null) {
					os.close();
				}
			}

		}
		return null;
	}*/

	/**
	 * 上传图片录入
	 * upload 上传url
	 * @return
	 */
	@RequestMapping("/uploadPage")
	public ModelAndView uploadPage(String module, String upload) {
		ModelAndView model = new ModelAndView("upload/uploadPage") ;
		model.addObject("upload", upload);
		Map<String, String> params = new HashMap<>() ;
		params.put("module", module) ;
		
		String maxSize = getRequest().getParameter("maxSize") ;
		String allowFiles = getRequest().getParameter("allowFiles") ;
		params.put("maxSize", maxSize) ;
		params.put("allowFiles", allowFiles) ;
		
		model.addObject("params", params) ;
		return model ;
	}
	
	/**
	 * 删除上传的文件(图片)
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public ResultMessage delete(String path) {
		if(FileUtil.delete(getRealPath() + path)) {
			return ResultMessage.successMsg("删除成功");
		} else {
			return ResultMessage.successMsg("删除失败");
		}
	}
	
	/**
	 * 测试
	 * 
	 * @return
	 */
	@RequestMapping("/test")
	public String test() {
		return "upload/test";
	}

}
