package com.sxit.model.system;

public class IdVo {
	private Integer id;

	public IdVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IdVo(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		IdVo other = (IdVo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.getId()))
		    return false;
	    return true;
	}
}
