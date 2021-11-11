package com.practice.Prcatice1.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author ganganayan.tl
 *
 */

public class GenericQueryCreationResultDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Object> data;
	private long totalCount;
	private String errorStackTrace;
	
	
	
	
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	
	public String getErrorStackTrace() {
		return errorStackTrace;
	}
	public void setErrorStackTrace(String errorStackTrace) {
		this.errorStackTrace = errorStackTrace;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}