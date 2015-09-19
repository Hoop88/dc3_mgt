package com.sxit.mgt.auth.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author agu
 *
 */
public class EMenuMap implements Serializable {
	
	private List<EMenu> mainList;
	
	private List<EMenu> barList;

	private HashMap<String,EMenu> level1MenuMap;
	
	private HashMap<String,EMenu> level2MenuMap;

	
	public EMenuMap() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<EMenu> getMainList() {
		return mainList;
	}


	public void setMainList(List<EMenu> mainList) {
		this.mainList = mainList;
	}


	public List<EMenu> getBarList() {
		return barList;
	}


	public void setBarList(List<EMenu> barList) {
		this.barList = barList;
	}


	public HashMap<String, EMenu> getLevel1MenuMap() {
		return level1MenuMap;
	}


	public void setLevel1MenuMap(HashMap<String, EMenu> level1MenuMap) {
		this.level1MenuMap = level1MenuMap;
	}


	public HashMap<String, EMenu> getLevel2MenuMap() {
		return level2MenuMap;
	}


	public void setLevel2MenuMap(HashMap<String, EMenu> level2MenuMap) {
		this.level2MenuMap = level2MenuMap;
	}

}
