package com.sxit.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.sxit.common.exception.ServiceException;

public class ExcelHelp {

	public static String getCellString(Cell cell) {
		DecimalFormat df = new DecimalFormat("###");
		try {
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_STRING:
				return cell.getStringCellValue();
			case HSSFCell.CELL_TYPE_NUMERIC:
				return df.format(cell.getNumericCellValue());
			case HSSFCell.CELL_TYPE_BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());
			case HSSFCell.CELL_TYPE_BLANK:
				return "";
			case HSSFCell.CELL_TYPE_ERROR:
				return String.valueOf(cell.getErrorCellValue());
			case HSSFCell.CELL_TYPE_FORMULA:
				return String.valueOf(cell.getCellFormula());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 获取客户工作表
	 * @param file
	 * @return Sheet
	 */
	public static Sheet getTarUserSheet(File file) throws ServiceException {
	    InputStream fis = null;
	    Sheet tarUserSheet = null;
	    try {
	        fis = new FileInputStream(file);
	        Workbook hssWb;
			
			hssWb = WorkbookFactory.create(fis);
	        tarUserSheet = hssWb.getSheetAt(0);
	    } catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
	        throw new ServiceException(e);
	    } catch (IOException e) {
	        throw new ServiceException(e);
	    } finally {
	        if (fis != null) {
	            try {
	                fis.close();
	            } catch (IOException e) {
	                throw new ServiceException(e);
	            }
	        }
	    }
	    return tarUserSheet;
	}
	
	public static String getCellStringTrim(HSSFCell cell) {
		String str = getCellString(cell);

		if (str != null)
			return str.trim();

		return null;
	}
	
	public static String getCellStringNoSpace(Cell cell) {
		String str = getCellString(cell);

		if (str != null)
			return str.replaceAll(" ", ""); 

		return null;
	}
	
	public static String getCellNotNullString(HSSFCell cell) {
		String str = getCellString(cell);
		
		if(str == null) {
			throw new NullPointerException();
		}
		
		return str;
	}
	
	public static String getCellNotNullStringTrim(HSSFCell cell) {
		return getCellNotNullString(cell).trim();
	}
}
