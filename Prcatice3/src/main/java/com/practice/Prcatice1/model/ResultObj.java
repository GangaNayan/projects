package com.practice.Prcatice1.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ResultObj implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Object> colclass;
	private long totalCount;
	
	
	
	public List<Object> getColclass() {
		return colclass;
	}
	public void setColclass(List<Object> colclass) {
		this.colclass = colclass;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
