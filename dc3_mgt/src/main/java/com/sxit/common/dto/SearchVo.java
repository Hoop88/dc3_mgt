package com.sxit.common.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class SearchVo implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3162842289137956753L;

	public String searchTxt;
	public int type = -1;
	public int state = -1;
	public String cityId;
	public String serviceId;

	public String cityName;
	
	public String beginDate;
	public String endDate;

	public Integer areaId = -1;
	public Integer depId = -1;


	


	public SearchVo() {
		super();
		// Auto-generated constructor stub
	}

	public Map<String, Object> getMap() {

		Map<String, Object> map = new HashMap<String, Object>();
		if (searchTxt != null && !"".equals(searchTxt)) {
			map.put("searchTxt", searchTxt);
		}



		if (areaId!=null && areaId > -1) {
			map.put("areaId", areaId);
		}

		if (depId!=null && depId > -1) {
			map.put("depId", depId);
		}

		if (type > -1) {
			map.put("type", type);
		}
		
		if (state > -1) {
			map.put("state", state);
		}
		
		if (cityName != null && !"".equals(cityName)) {
			map.put("cityName", cityName);
		}

		if (beginDate != null && !"".equals(beginDate)) {
			map.put("beginDate", beginDate);
		}

		if (endDate != null && !"".equals(endDate)) {
			map.put("endDate", endDate);
		}

		if (cityId != null && !"".equals(cityId) && !"-1".equals(cityId)) {
			map.put("cityId", cityId);
		}

		if (serviceId != null && !"".equals(serviceId) && !"-1".equals(serviceId)) {
			map.put("serviceId", serviceId);
		}


		return map;
	}

	public String getSearchTxt() {
		return searchTxt;
	}

	public void setSearchTxt(String searchTxt) {
		this.searchTxt = searchTxt;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public static String toIdString(Set<String> set) {
		StringBuilder sb = new StringBuilder();
		for (String str : set) {
			if (sb.length() == 0) {
				sb.append("'" + str + "'");
			} else {
				sb.append(",'" + str + "'");
			}
		}
		return sb.toString();
	}
}
