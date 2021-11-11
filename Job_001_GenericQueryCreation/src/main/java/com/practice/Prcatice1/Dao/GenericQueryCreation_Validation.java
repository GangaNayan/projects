package com.practice.Prcatice1.Dao;

import com.practice.Prcatice1.model.GenericQueryCreationDTO;

/**
 * 
 * @author ganganayan.tl
 *
 */
public class GenericQueryCreation_Validation {
	
	

	public boolean isPositiveNumbers(GenericQueryCreationDTO gqcd) {
		boolean b=true;
		
		long startIndex=gqcd.getStartIndex();
		long endIndex=gqcd.getEndIndex();
		
		if(startIndex<0 || endIndex<0) {
			b=false;
		}else {
			b=true;
		}
		return b;
		
	}
	
	public boolean isEndIndexGraterThanStartIndex(GenericQueryCreationDTO gqcd) {
		boolean b=true;
		
		long startIndex=gqcd.getStartIndex();
		long endIndex=gqcd.getEndIndex();
		
		if(startIndex>endIndex) {
			b=false;
		}else {
			b=true;
		}
		return b;
		
	}
	
	public boolean isEndIndexGraterThanZero(GenericQueryCreationDTO gqcd) {
		boolean b=true;
		
		long startIndex=gqcd.getStartIndex();
		long endIndex=gqcd.getEndIndex();
		
		if(endIndex==0) {
			b=false;
		}else {
			b=true;
		}
		return b;
		
	}
	
	public boolean isLimitLessThanOrEqualToThousand(GenericQueryCreationDTO gqcd) {
		boolean b=true;
		
		long startIndex=gqcd.getStartIndex();
		long endIndex=gqcd.getEndIndex();
		
		if(endIndex-startIndex>1000) {
			b=false;
		}else {
			b=true;
		}
		return b;
	}
	
	public boolean isSelectQuery(GenericQueryCreationDTO gqcd) {
		
		boolean b=true;
		
		String query=gqcd.getQuery();
		if(query.stripLeading().toLowerCase().startsWith("select")) {
			b=true;
		}else {
			b=false;
		}
		return b;
	}
	

	
//	public boolean isValidNumber(long startIndex,long endIndex) {
//		boolean b=false;
//		startIndex='A';
//		endIndex='B';
//		if(startIndex>endIndex) {
//			
//		}
//		
//		return b;
//	}

}
