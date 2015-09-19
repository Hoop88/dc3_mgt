package com.sxit.common.excel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Merger {

	private String newCstGUID;
	private String oldCstGUIDList;
	private String newMemGUID;

	public Merger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNewCstGUID() {
		return newCstGUID;
	}

	@XslImport(name = "新客户号", columnNum = 1, regex = "", notNull = true, type = DataEnum.String, maxLength = 500)
	public void setNewCstGUID(String newCstGUID) {
		this.newCstGUID = newCstGUID;
	}

	public String getOldCstGUIDList() {
		return oldCstGUIDList;
	}

	@XslImport(name = "老客户号", columnNum = 2, regex = "", notNull = true, type = DataEnum.String, maxLength = 2000)
	public void setOldCstGUIDList(String oldCstGUIDList) {
		this.oldCstGUIDList = oldCstGUIDList;
	}

	public String getNewMemGUID() {
		return newMemGUID;
	}

	@XslImport(name = "新会员号", columnNum = 3, regex = "", notNull = false, type = DataEnum.String, maxLength = 500)
	public void setNewMemGUID(String newMemGUID) {
		this.newMemGUID = newMemGUID;
	}

	/**
	 * @Description: TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ExcelImport<Merger> ei = new ExcelImport();

			boolean b = ei.validate("C:\\D\\excel1.xls", Merger.class, null);

			if (b) {
				System.out.println("导入成功!");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				for (Merger o : ei.getDataList()) {
					Merger me = (Merger) o;
					System.out.print(me.getNewCstGUID());
					System.out.print(" ");
					System.out.print(me.getOldCstGUIDList());
					System.out.print(" ");
					System.out.println(me.getNewMemGUID());
				}

			} else {
				for (String msg : ei.getMsgList()) {
					System.out.println(msg);
				}

			}
			
			System.out.println("总计:"+ei.getDataList().size());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
