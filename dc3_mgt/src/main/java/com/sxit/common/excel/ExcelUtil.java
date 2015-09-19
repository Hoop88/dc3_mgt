package com.sxit.common.excel;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.sxit.common.memery.ExportMap;
import com.sxit.model.system.SysExportColumn;

public class ExcelUtil {

	/**
	 * 将list导出为Excel
	 * 
	 * @Description: TODO
	 * @param list
	 * @param exportCode
	 * @param sheetName
	 * @param map
	 * @return
	 */
	public static ExcelExport exportList(
			@SuppressWarnings("rawtypes") List list, String exportCode,
			String sheetName, Map map) {

		if (list != null && list.size() > 0) {

			// 根据exportCode 获取需要导出的列
			Map expmap = ExportMap.getExport();
			List<SysExportColumn> colset = (List) expmap.get(exportCode);
			
			if(colset==null)
			{
				return null;
			}

			ExcelExport xls = new ExcelExport(true, sheetName);
			xls.createRow(1); // 输入标题栏
			int j = 1;
			int i = 2;
			// xls.createStyle1();

			for (SysExportColumn col : colset) {
				xls.setTitleCell(j++, col.getColumnName());
			}

			for (Object o : list) {
				xls.createRow(i++);
				j = 1;
				for (SysExportColumn col : colset) {
					int coltype = col.getColumnType();
					String colname = col.getColumnValue();
					Object value = getMethodValue(o, colname);

					switch (coltype) {
					case 1: // 正常值
						xls.setCell(j++, value);
						break;
					case 2: // map;
						if (map == null) {
							xls.setCell(j++, "");
							break;
						}
						Object mo = map.get(col.getMapKey());
						if (mo == null) {
							xls.setCell(j++, "");
							break;
						}
						Map m = (Map) mo;
						Object mv = m.get(value);
						if (mv == null) {
							xls.setCell(j++, "");
							break;
						}
						xls.setCell(j++, mv);
						break;
					case 3: // 日期
						if (!StringUtils.isBlank(col.getDateFormat())) {
							xls.setDateCell(j++, value, col.getDateFormat());
						} else {
							xls.setDateCell(j++, value);
						}
						break;
					default:
						xls.setCell(j++, value);
					}
				}
			}

			xls.setColumnWidth(0, 500);
			j = 1;
			for (SysExportColumn col : colset) {
				// xls.setColumnAutoWidth(j++);
				xls.setColumnWidth(j++, 5500);
			}

			return xls;
		} else {
			return null;
		}
	}

	/**
	 * 转换为get方法名
	 * 
	 * @Description: TODO
	 * @param name
	 * @return
	 */
	public static String toMethodName(String name) {
		if (name == null) {
			return "";
		} else if (name.length() == 0) {
			return "";
		} else if (name.length() == 1) {
			return "get" + name.toUpperCase();
		} else {
			return "get" + name.substring(0, 1).toUpperCase()
					+ name.substring(1);
		}
	}

	/**
	 * 获取方法
	 * 
	 * @Description: TODO
	 * @param methods
	 * @param methodName
	 * @return
	 */
	public static Method getMethod(Method[] methods, String methodName) {

		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				return method;
			}
		}
		return null;
	}

	/**
	 * 获取对象方法的值 支持对象的对象 例如 user.name
	 * 
	 * @Description: TODO
	 * @param o
	 * @param colname
	 * @return
	 */
	public static Object getMethodValue(Object o, String colname) {
		if (o == null) {
			return null;
		}
		String[] ms = colname.split("\\.");
		Object to = o;
		int i = 0;
		for (String s : ms) {
			i++;
			if (to != null) {
				Method[] methods = to.getClass().getMethods();
				Method method = getMethod(methods, toMethodName(s));

				if (method != null) {
					try {
						to = method.invoke(to);
					} catch (Exception e) {
						to = null;
					}
				} else {
					to = null;
				}
			}

		}
		if (i >= 1) {
			return to;
		}
		return null;
	}

	/**
	 * 从字符串返回布尔值
	 * 
	 * @Description: TODO
	 * @param b
	 * @return
	 */
	public static boolean parseBoolean(String b) {
		if (b == null) {
			return false;
		}
		if ("是".equals(b.trim()) || "1".equals(b.trim())
				|| "true".equals(b.trim().toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}

	public static Date parseDate(String t) throws Exception {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (t == null) {
			return null;
		}
		return sFormat.parse(t);
	}

	public static Timestamp parseTimestamp(String t) throws Exception {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (t == null) {
			return null;
		}
		Date d = sFormat.parse(t);
		return new Timestamp(d.getTime());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String colname = "xxx.xx";
		String[] ms = colname.split("\\.");

		for (String s : ms) {
			System.out.println(s);
		}

	}

}
