package com.sxit.common.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 利用开源组件POI3.0.2动态导出EXCEL文档
 * 转载时请保留以下信息，注明出处！
 * @author leno
 * @version v1.0
 * @param <T> 应用泛型，代表任意一个符合javabean风格的类
 * 注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx()
 * byte[]表jpg格式的图片数据
 */
public class ExcelExportUtil {
	
	private static Log log = LogFactory.getLog(ExcelExportUtil.class);
	
   /**
    * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
    * 
    * @param title
    *            表格标题名
    * @param headers
    *            表格属性列名数组
    * @param dataset
    *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
    *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
    * @param out
    *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
    */
   @SuppressWarnings({ "unchecked", "deprecation" })
   public static void exportExcel(HttpServletResponse response, String title, String[] headers, Collection dataset)  throws Exception {
      // 声明一个工作薄
      HSSFWorkbook workbook = new HSSFWorkbook();
      // 生成一个表格
      HSSFSheet sheet = workbook.createSheet(title);
      // 设置表格默认列宽度为15个字节
      sheet.setDefaultColumnWidth((short) 15);
      // 生成一个样式
      HSSFCellStyle style = workbook.createCellStyle();
      // 设置这些样式
      style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
      style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
      style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
      style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
      style.setBorderRight(HSSFCellStyle.BORDER_THIN);
      style.setBorderTop(HSSFCellStyle.BORDER_THIN);
      style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
      // 生成一个字体
      HSSFFont font = workbook.createFont();
      font.setColor(HSSFColor.VIOLET.index);
      font.setFontHeightInPoints((short) 12);
      font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
      // 把字体应用到当前的样式
      style.setFont(font);
      // 生成并设置另一个样式
      HSSFCellStyle style2 = workbook.createCellStyle();
      style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
      style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
      style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
      style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
      style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
      style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
      style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
      style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
      // 生成另一个字体
      HSSFFont font2 = workbook.createFont();
      font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
      // 把字体应用到当前的样式
      style2.setFont(font2);
      
      // 声明一个画图的顶级管理器
      HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
      // 定义注释的大小和位置,详见文档
      HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
      // 设置注释内容
      comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
      // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
      comment.setAuthor("leno");
      //产生表格标题行
      HSSFRow row = sheet.createRow(0);
      for (short i = 0; i < headers.length; i++) {
         HSSFCell cell = row.createCell(i);
         cell.setCellStyle(style);
         HSSFRichTextString text = new HSSFRichTextString(headers[i]);
         cell.setCellValue(text);
      }
      //遍历集合数据，产生数据行
      Iterator it = dataset.iterator();
      int index = 0;
      while (it.hasNext()) {
         index++;
         row = sheet.createRow(index);
         Object t = it.next();
         //利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
         Field[] fields = t.getClass().getDeclaredFields();
         for (short i = 0; i < fields.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style2);
            Field field = fields[i];
            String fieldName = field.getName();
            String getMethodName = "get"
                   + fieldName.substring(0, 1).toUpperCase()
                   + fieldName.substring(1);
            Class tCls = t.getClass();
            Method getMethod = tCls.getMethod(getMethodName,
                  new Class[] {});
            Object value = getMethod.invoke(t, new Object[] {});
            //判断值的类型后进行强制类型转换
            String textValue = "";
            if (value instanceof byte[]) {
               // 有图片时，设置行高为60px;
               row.setHeightInPoints(60);
               // 设置图片所在列宽度为80px,注意这里单位的一个换算
               sheet.setColumnWidth(i, (short) (35.7 * 80));
               // sheet.autoSizeColumn(i);
               byte[] bsValue = (byte[]) value;
               HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
                     1023, 255, (short) 6, index, (short) 6, index);
               anchor.setAnchorType(2);
               patriarch.createPicture(anchor, workbook.addPicture(
                     bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
            } else {
               if (value != null) {
            	   // 其它数据类型都当作字符串简单处理
            	   textValue = value.toString();
               }
            }
            // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
            if (textValue != null) {
               Pattern p = Pattern.compile("^//d+(//.//d+)?$");   
               Matcher matcher = p.matcher(textValue);
               if (matcher.matches()) {
                  //是数字当作double处理
                  cell.setCellValue(Double.parseDouble(textValue));
               } else {
                  HSSFRichTextString richString = new HSSFRichTextString(textValue);
                  HSSFFont font3 = workbook.createFont();
                  font3.setColor(HSSFColor.BLUE.index);
                  richString.applyFont(font3);
                  cell.setCellValue(richString);
               }
            }
         }
      }
      
      try {
    	  String fileName = title + ".xls";
    	  // 设置导出文件的头信息
    	  response.setContentType("application/x-download");
    	  response.setHeader("Content-disposition", "attachment; filename="+ new String(fileName.getBytes("GB2312"),"ISO8859-1")); 
    	  OutputStream out = response.getOutputStream();
    	  workbook.write(out);
    	  out.close();
      } catch (IOException e) {
         log.error("下载失败", e);
      }
   }

}
