package com.practice.Prcatice1.model;

import java.io.Serializable;

import java.util.List;

/**
 * 
 * @author ganganayan.tl
 *
 */

public class GenericQueryCreationDTO implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private long startIndex;
	private long endIndex;
	private String query;
	
//	GenericQueryCreationDTO(){
//		if(startIndex==0) {
//			this.startIndex=1;
//		}
//	}
	
	public long getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(long startIndex) {
		this.startIndex = startIndex;
	}

	public long getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(long endIndex) {
		this.endIndex = endIndex;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}