package com.sxit.common.excel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;


public class ExcelImport<T> {
	private List<T> dataList;
	private List<String> msgList;

	/**
	 * 校验导入的文件里面的数据是否符合要求的方法
	 * 
	 * @param file
	 * @return
	 */
	public boolean validate(String filePath,
			@SuppressWarnings("rawtypes") Class clazz, Map map)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InstantiationException, ParseException {

		msgList = new ArrayList<String>();
		dataList = new ArrayList();

		ExcelReader reader = new ExcelReader();

		Map<Integer, String[]> datamap = reader.readExcelContent(filePath);

		Map<Integer, XslImport> xslImportMap = new HashMap<Integer, XslImport>();
		Map<Integer, Method> methodMap = new HashMap<Integer, Method>();

		int i = 0;

		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(XslImport.class)) {
				XslImport im = method.getAnnotation(XslImport.class);
				methodMap.put(im.columnNum(), method);
				xslImportMap.put(im.columnNum(), im);
				
				//System.out.println("--"+im.columnNum());
			}
		}

		for (Integer key : datamap.keySet()) {
			T obj = (T) clazz.newInstance();
			String[] values = datamap.get(key);
			i++;
			for (int column = 0; column < values.length; column++) {
				String field = values[column];
				XslImport xslField = xslImportMap.get(column + 1);
				Method method = methodMap.get(column + 1);
				//System.out.println(column);
				if(xslField!=null)
				{
					if (StringUtils.isBlank(field)  &&  xslField.notNull()) {
						StringBuilder sb = new StringBuilder();
						sb.append("第").append(i).append("行数据存在空值!");
						msgList.add(sb.toString());
					}

				}
				
				//System.out.println("--"+(column + 1));
				if(xslField==null)
				{
					continue;
				}
				switch (xslField.type()) {
				case String:
					method.invoke(obj, field);
					
					//判断正则表达式
					if(!StringUtils.isBlank(xslField.regex()) && !StringUtils.isBlank(field))
					{
						String regEx = xslField.regex();
						String value = field.toString();
						boolean b =Pattern.matches(regEx, value.trim());
						
						if(!b)
						{
							StringBuilder sb = new StringBuilder();
							sb.append("第").append(i).append("行")
									.append(xslField.name() + "格式错误")
									.append(" "+field);
							msgList.add(sb.toString());
						}
					}
					
					break;
				case Date:
					try {
						method.invoke(obj, ExcelUtil.parseDate(field));
					} catch (Exception e1) {
						StringBuilder sb = new StringBuilder();
						sb.append("第").append(i).append("行")
								.append(xslField.name() + "日期格式错误")
								.append("");
						msgList.add(sb.toString());
					}
					break;
				case Timestamp:
					try {
						method.invoke(obj, ExcelUtil.parseTimestamp(field));
					} catch (Exception e1) {
						StringBuilder sb = new StringBuilder();
						sb.append("第").append(i).append("行")
								.append(xslField.name() + "日期格式错误")
								.append("");
						msgList.add(sb.toString());
					}
					break;
				case Boolean:
					method.invoke(obj, ExcelUtil.parseBoolean(field));
					break;
				case Int:
					try {
						if("".equals(field))
						{
							method.invoke(obj,0);
						}else{
							int value = Integer.parseInt(field.toString());
							method.invoke(obj,value);
						}

					} catch (Exception e) {
						e.printStackTrace();
						StringBuilder sb = new StringBuilder();
						sb.append("第").append(i).append("行")
								.append(xslField.name() + "数字格式错误")
								.append("");
						msgList.add(sb.toString());
					}
					break;
				case Long:
					try {
						if("".equals(field))
						{
							method.invoke(obj, 0l);
						}else{
							method.invoke(obj, Long.parseLong(field));
						}
						
					} catch (NumberFormatException e) {
						StringBuilder sb = new StringBuilder();
						sb.append("第").append(i).append("行")
								.append(xslField.name() + "数字格式错误")
								.append("");
						msgList.add(sb.toString());
					}
					break;
				case Float:
					try {
						if("".equals(field))
						{
							method.invoke(obj, 0);
						}else{
							method.invoke(obj, Float.parseFloat(field));
						}
						
					} catch (NumberFormatException e) {
						StringBuilder sb = new StringBuilder();
						sb.append("第").append(i).append("行")
								.append(xslField.name() + "数字格式错误")
								.append("");
						msgList.add(sb.toString());
					}
					break;
				case Double:
					try {
						if("".equals(field))
						{
							method.invoke(obj, 0);
						}else{
							method.invoke(obj, Double.parseDouble(field));
						}
						
					} catch (NumberFormatException e) {
						StringBuilder sb = new StringBuilder();
						sb.append("第").append(i).append("行")
								.append(xslField.name() + "数字格式错误")
								.append("");
						msgList.add(sb.toString());
					}
					break;
				case BigDecimal:
					try {
						if("".equals(field))
						{
							method.invoke(obj, new BigDecimal(0));
						}else{
							method.invoke(obj, new BigDecimal(field));
						}
						
					} catch (NumberFormatException e) {
						StringBuilder sb = new StringBuilder();
						sb.append("第").append(i).append("行")
								.append(xslField.name() + "数字格式错误")
								.append("");
						msgList.add(sb.toString());
					}
					break;
				case Map:
					try {
						if (!StringUtils.isBlank(xslField.mapName())) {
							Map fieldmap = (Map) map.get(xslField.mapName());

							if (fieldmap != null) {
								method.invoke(obj, fieldmap.get(field));
							}
						} else {
							StringBuilder sb = new StringBuilder();
							sb.append(xslField.name() + "格式配置错误,请与管理员联系")
									.append("");
							msgList.add(sb.toString());
						}
					} catch (Exception e) {
						StringBuilder sb = new StringBuilder();
						sb.append("第").append(i).append("行")
								.append(xslField.name() + "格式错误")
								.append("");
						msgList.add(sb.toString());
					}
					break;
				default:
					break;
				}
			}
			dataList.add((T)obj);
		}
		if (msgList.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	public List<String> getMsgList() {
		return msgList;
	}

	public void setMsgList(List<String> msgList) {
		this.msgList = msgList;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List dataList) {
		this.dataList = dataList;
	}

	/**
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ExcelImport<KuaiDi> ei = new ExcelImport();
			
			boolean b = ei.validate("C:\\D\\myjava\\yidong\\rossini\\src\\main\\webapp\\download\\excelimport.xls", KuaiDi.class, null);

			if(b)
			{
				System.out.println("导入成功!");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				for(Object o:ei.dataList)
				{
					KuaiDi kd = (KuaiDi)o;
					System.out.print(kd.getBillId());
					System.out.print(" ");
					System.out.print(kd.getSendId());
					System.out.print(" ");
					System.out.print(sdf.format(kd.getSendTime()));
					System.out.print(" ");
					System.out.print(kd.getSendCorp());
					System.out.print(" ");
					System.out.println(kd.getSendInfo());
				}
				
			}else{
				for(String msg:ei.getMsgList())
				{
					System.out.println(msg);
				}
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
