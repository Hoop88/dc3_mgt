/**
 * ExcelExport.java
 */
package com.sxit.common.excel;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * @author 刘哈哈 Jun 9, 201112:01:21 AM
 * 
 */
public class ExcelExport {
	// 设置cell编码解决中文高位字节截断
	// private static short XLS_ENCODING = Cell;
	// 定制日期格式
	private static String DATE_FORMAT = "m/d/yy h:mm"; // "m/d/yy h:mm"
	// 定制浮点数格式
	private static String NUMBER_FORMAT = " ###0.00 ";

	private String xlsFileName;
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	private HSSFPatriarch patriarch;// 画图器

	private boolean is2003;

	/**
	 * 初始化Excel
	 * 
	 * @param fileName
	 *            导出文件名
	 */
	public ExcelExport(String fileName) {
		this.xlsFileName = fileName;
		int idx = fileName.lastIndexOf(".");
		String regix = fileName.substring(idx + 1);
		if (regix.equalsIgnoreCase("xls")) {
			is2003 = true;
			this.workbook = new HSSFWorkbook();
		} else if (regix.equalsIgnoreCase("xlsx")) {
			this.workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook();
		} else {
			throw new RuntimeException("文件名后缀不是正确的Excel文件格式后缀");
		}
		this.sheet = workbook.createSheet();
	}

	public ExcelExport(boolean is2003) {
		this.is2003 = is2003;
		if (is2003) {
			this.workbook = new HSSFWorkbook();
		} else {
			this.workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook();
		}
		this.sheet = workbook.createSheet();
	}

	/**
	 * 是创建2003的呢还是创建2007的
	 * 
	 * @param is2003
	 */
	public ExcelExport(boolean is2003, String sheetName) {
		this.is2003 = is2003;
		if (is2003) {
			this.workbook = new HSSFWorkbook();
		} else {
			this.workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook();
		}
		this.sheet = workbook.createSheet(sheetName);
	}

	/**
	 * 针对批量导出付款凭证
	 * 
	 * @param is2003
	 */
	public ExcelExport(boolean is2003, String sheetName, boolean isTyle) {
		this.is2003 = is2003;
		if (is2003) {
			this.workbook = new HSSFWorkbook();
		} else {
			this.workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook();
		}
		this.sheet = workbook.createSheet(sheetName);
		if (isTyle) {
			sheet.setPrintGridlines(true);
		}
		sheet.setColumnWidth(0, (short) (35.7 * 20));
		sheet.setColumnWidth(1, (short) (35.7 * 120));
		sheet.setColumnWidth(2, (short) (35.7 * 180));
		sheet.setColumnWidth(3, (short) (35.7 * 20));
		sheet.setColumnWidth(4, (short) (35.7 * 80));
		sheet.setColumnWidth(5, (short) (35.7 * 220));
	}

	/**
	 * 导出Excel文件
	 * 
	 * @throws XLSException
	 */
	public void exportXLS() throws Exception {
		FileOutputStream fOut = new FileOutputStream(xlsFileName);
		workbook.write(fOut);
		fOut.flush();
		fOut.close();
	}

	/**
	 * 获取输出流
	 * 
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 */
	public ByteArrayOutputStream getExportStream() throws Exception {
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		workbook.write(bOut);
		return bOut;
	}

	/**
	 * 写入流
	 * 
	 * @Description: TODO
	 * @param out
	 * @throws Exception
	 */
	public void WriteExcel(OutputStream out) throws IOException {
		workbook.write(out);
	}

	/**
	 * 创建一个顶级画图器
	 * 
	 * @return
	 * @throws Exception
	 */
	public HSSFPatriarch createPatriarch() throws Exception {
		// 生成一个顶级画图器
		patriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();

		// 定义注释的大小和位置
		// HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
		// 0, 0, 0, (short) 4, 2, (short) 6, 5));

		// 设置注释内容
		// comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		// comment.setAuthor("lwh");

		return patriarch;

	}

	/**
	 * 创建放图片的cell
	 * 
	 * @param index
	 * @param row1
	 * @param bsValue
	 */
	public void setCellPic(int index, int row1, byte[] bsValue) {
		// 有图片时，设置行高为60px;
		row.setHeightInPoints(120);
		// 设置图片所在列宽度为80px,注意这里单位的一个换算
		// sheet.setColumnWidth(index, (short) (35.7 * 160));
		HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 255,
				(short) index, row1, (short) index, row1);
		anchor.setAnchorType(2);

		patriarch.createPicture(anchor,
				workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
	}

	/**
	 * 合并
	 * 
	 * @param index
	 * @param row1
	 * @param bsValue
	 */
	public void groupRowAndCell(int srow, int erow, int scell, int ecell) {
		sheet.addMergedRegion(new CellRangeAddress(srow, (short) erow, scell,
				(short) ecell));

	}

	/**
	 * 导出Excel文件
	 * 
	 * @throws XLSException
	 */
	public void exportXLS(OutputStream os) throws Exception {
		// FileOutputStream fOut = new FileOutputStream(xlsFileName);
		workbook.write(os);
		os.flush();
		os.close();
	}

	/**
	 * 增加一行
	 * 
	 * @param index
	 *            行号
	 */
	public void createRow(int index) {
		this.row = this.sheet.createRow(index);
	}

	/**
	 * 设置单元格
	 * 
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, String value) {
		Cell cell = this.row.createCell(index);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		// cell.setEncoding(XLS_ENCODING);
		cell.setCellValue(value);
	}

	/**
	 * 针对数字改变科学计算法设置
	 * 
	 * @param index
	 * @param value
	 */
	public void setDataForamteCell(int index, String value) {
		Cell cell = this.row.createCell(index);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(value);
	}

	private CellStyle titleStyle;
	private CellStyle contentStyle;
	private CellStyle dateStyle;
	public void createTitleStyle() {
		
		if(titleStyle==null)
		{
			titleStyle = workbook.createCellStyle();
			titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			titleStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN
					.getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			titleStyle.setRightBorderColor(HSSFColor.BLACK.index);
			titleStyle.setTopBorderColor(HSSFColor.BLACK.index);
			titleStyle.setLeftBorderColor(HSSFColor.BLACK.index);
			titleStyle.setBottomBorderColor(HSSFColor.BLACK.index);
			titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
		}
		
	}
	
	public void createContentStyle() {
		if(contentStyle==null )
		{
			contentStyle = workbook.createCellStyle();
			
			contentStyle.setRightBorderColor(HSSFColor.BLACK.index);
			contentStyle.setTopBorderColor(HSSFColor.BLACK.index);
			contentStyle.setLeftBorderColor(HSSFColor.BLACK.index);
			contentStyle.setBottomBorderColor(HSSFColor.BLACK.index);
			contentStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			contentStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			contentStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			contentStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			contentStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			contentStyle.setAlignment(CellStyle.ALIGN_CENTER);
		}
	}
	
	public void createDateStyle() {
		
		if(dateStyle==null )
		{
			dateStyle = workbook.createCellStyle();
			
			dateStyle.setRightBorderColor(HSSFColor.BLACK.index);
			dateStyle.setTopBorderColor(HSSFColor.BLACK.index);
			dateStyle.setLeftBorderColor(HSSFColor.BLACK.index);
			dateStyle.setBottomBorderColor(HSSFColor.BLACK.index);
			dateStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			dateStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			dateStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			dateStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			dateStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			dateStyle.setAlignment(CellStyle.ALIGN_CENTER);
		}
		

	}

	public void setTitleCell(int index, String value) {
		Cell cell = this.row.createCell(index);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		this.createTitleStyle();
		cell.setCellStyle(titleStyle);
		row.setHeight((short) (15.625 * 35));
		cell.setCellValue(new HSSFRichTextString(value));
	}

	public void setColumnWidth(int index, int value) {
		this.sheet.setColumnWidth(index, value);
	}

	public void setColumnAutoWidth(int index) {
		this.sheet.autoSizeColumn(index);
	}

	/**
	 * 设置单元格
	 * 
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, Calendar value) {
		Cell cell = this.row.createCell(index);
		// cell.setEncoding(XLS_ENCODING);
		cell.setCellValue(value.getTime());
		CellStyle cellStyle = workbook.createCellStyle(); // 建立新的cell样式
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(DATE_FORMAT)); // 设置cell样式为定制的日期格式
		// cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("yy/m/d h:mm"));//设置cell样式为定制的日期格式
		cell.setCellStyle(cellStyle); // 设置该cell日期的显示格式
	}

	/**
	 * 设置单元格
	 * 
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, int value) {
		Cell cell = this.row.createCell(index);
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(value);
	}

	/**
	 * 设计表格内容
	 * 
	 * @Description: TODO
	 * @param index
	 * @param value
	 */
	public void setCell(int index, Object value) {
		createContentStyle();
		row.setHeight((short) (15.625 * 28));
		Cell cell = this.row.createCell(index);
		// boolean，char，byte，double，short，int，long，float
		if (value instanceof Boolean || value instanceof Short
				|| value instanceof Integer || value instanceof Long
				|| value instanceof Float || value instanceof Double) {
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(value.toString());
			cell.setCellStyle(contentStyle);
		} else if (value instanceof java.util.Date
				|| value instanceof java.sql.Date
				|| value instanceof java.sql.Timestamp
				|| value instanceof Calendar) {
			setDateCell(index, value);
		} else {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			if (value == null) {
				cell.setCellValue("");
			} else {
				cell.setCellValue(value.toString());
			}
			cell.setCellStyle(contentStyle);
		}
	}

	/**
	 * 设计日期
	 * 
	 * @Description: TODO
	 * @param index
	 * @param value
	 */
	public void setDateCell(int index, Object value) {
		setDateCell(index, value, DATE_FORMAT);
	}

	/**
	 * 设置日期
	 * 
	 * @Description: TODO
	 * @param index
	 * @param value
	 * @param format
	 */
	public void setDateCell(int index, Object value, String format) {
		Cell cell = this.row.createCell(index);
		if (value instanceof java.util.Date) {
			cell.setCellValue((java.util.Date) value);
		} else if (value instanceof java.sql.Date) {
			cell.setCellValue(HSSFDateUtil.getExcelDate((java.sql.Date) value));
		} else if (value instanceof java.sql.Timestamp) {
			cell.setCellValue(HSSFDateUtil
					.getExcelDate((java.sql.Timestamp) value));
		} else if (value instanceof Calendar) {
			Calendar cal = (Calendar) value;
			java.util.Date date = new java.util.Date();
			cell.setCellValue(HSSFDateUtil.getExcelDate(cal.getTime()));
		} else {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			if (value == null) {
				cell.setCellValue("");
			} else {
				cell.setCellValue(value.toString());
			}
		}
		createDateStyle();

		HSSFDataFormat dataFormat = (HSSFDataFormat) workbook.createDataFormat();  
		dateStyle.setDataFormat(dataFormat.getFormat(format)); // 设置cell样式为定制的日期格式
		cell.setCellStyle(dateStyle); // 设置该cell日期的显示格式
	}

	/**
	 * 设置单元格
	 * 
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, double value) {
		Cell cell = this.row.createCell(index);
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(value);
		CellStyle cellStyle = workbook.createCellStyle(); // 建立新的cell样式
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat(NUMBER_FORMAT)); // 设置cell样式为定制的浮点数格式

		cell.setCellStyle(cellStyle); // 设置该cell浮点数的显示格式
	}

	public static void main(String args[]) throws Exception {
		ExcelExport xls = new ExcelExport("d:/aaabb.xlsx");
		for (int i = 0; i < 10; i++) {
			xls.createRow(i);
			for (int j = 0; j < 10; j++) {
				if (j == 9) {

					Calendar c = Calendar.getInstance();
					xls.setCell(j, c);
				}

				else if (j == 8)
					xls.setCell(j, 12131421241243.21d);
				else if (j == 7) {
					xls.setCell(j, 1234567890);
				} else {
					xls.setCell(j, "测试:" + i + "," + j);
				}
			}
		}
		xls.exportXLS();
	}

}
