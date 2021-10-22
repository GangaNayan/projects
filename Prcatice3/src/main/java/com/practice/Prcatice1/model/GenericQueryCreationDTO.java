package com.practice.Prcatice1.model;

import java.io.Serializable;
import java.util.List;

public class GenericQueryCreationDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String query;
	
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
