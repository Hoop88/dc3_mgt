/**
 * 
 */
package com.sxit.common.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelReader {
	private POIFSFileSystem fs;
	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFRow row;
	private FileInputStream input;
	private String[] excleTitle;

	public String[] readExcelTitle(String excelPath) {// 读取Excel表格表头的内容
		try {
			input = new FileInputStream(new File(excelPath));// excelPath,Excel
			// 文件 的绝对路径
			fs = new POIFSFileSystem(input);
			wb = new HSSFWorkbook(fs);
			sheet = wb.getSheetAt(0);
			row = sheet.getRow(0);// 得到标题的内容对象。
			int colNum = row.getPhysicalNumberOfCells(); // 得到标题总列数
			excleTitle = new String[colNum];
			for (int i = 0; i < colNum; i++) {
				excleTitle[i] = getStringCellValue(row.getCell((short) i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return excleTitle;
	}

	public Map<Integer, String[]> readExcelContent(String excelPath) {// 读取Excel数据内容
		Map<Integer, String[]> content = new HashMap<Integer, String[]>();
		String excelStr = "";// excel 内容
		try {
			input = new FileInputStream(new File(excelPath));
			fs = new POIFSFileSystem(input);
			wb = new HSSFWorkbook(fs);
			sheet = wb.getSheetAt(0);
			int rowNum = sheet.getLastRowNum(); // 得到总行数
			row = sheet.getRow(0);// 得到标题的内容对象。
			int colNum = row.getPhysicalNumberOfCells();// 得到每行的列数。
			for (int i = 1; i <= rowNum; i++) { // 正文内容应该从第二行开始,第一行为表头的标题
				row = sheet.getRow(i);
				if (row != null) {
					int j = 0;
					String[] s = new String[colNum];
					while (j < colNum) {
						s[j] = getStringCellValue(row.getCell(j)).trim();
						j++;
					}
					content.put(i, s);
					excelStr = "";
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}

	private String getStringCellValue(HSSFCell cell) {// 获取单元格数据内容为字符串类型的数据
		if (cell == null) {
			return "";
		}
		String strCell = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:
			strCell = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				double d = cell.getNumericCellValue();
				Date date = HSSFDateUtil.getJavaDate(d);
				SimpleDateFormat sFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				strCell = sFormat.format(date);
				break;
			}
			strCell = String.valueOf((long) cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			strCell = String.valueOf(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			strCell = "";
			break;
		default:
			strCell = "";
			break;
		}
		if (strCell.equals("") || strCell == null) {
			return "";
		}
		return strCell.trim();
	}

	/**
	 * @param String类型的数字
	 *            如"150"
	 * @param 格式化格式
	 *            ，如“00000”
	 * @return 格式化后的字符串
	 */
	public static String formatNumber(String str, String formatAs) {
		DecimalFormat df = new DecimalFormat(formatAs);
		String str2 = df.format(Integer.parseInt(str));
		return str2;
	}

	public static void main(String[] args) {
		ExcelReader excelReader = new ExcelReader();
		String[] ss = excelReader.readExcelTitle("/Users/wuguirongsg/pl.xls");
		for (String s : ss) {
			System.out.println(s);
		}
		Map<Integer, String[]> map = excelReader
				.readExcelContent("/Users/wuguirongsg/pl.xls");
		String sql = "insert into xfzn_comments (sellerid,name,content,mark) values (";
		for (int i = 0; i < map.size(); i++) {
			String[] m = map.get(i + 1);
			String s = "";
			for (int j = 0; j < m.length; j++) {
				if (j == 1) {
					s += "'" + m[j].replaceAll("'", "") + "'";
				} else if (j == 2) {
					String x = m[j].replaceAll("'", "");
					if (x.length() >= 150)
						s += "'" + x.substring(0, 145) + "...'";
					else
						s += "'" + x + "'";
				} else {
					s += m[j];
				}
				if (j + 1 < m.length) {
					s += ",";
				}
			}
			System.out.print(sql + s + ");");
			System.out.print("\n");
		}
	}
}