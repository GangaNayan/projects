package com.practice.Prcatice1.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

	/**
	 * 
	 * @author ganganayan.tl
	 *
	 */

public class ResultObj {
		/**
		 * 
		 */
        private static final long serialVersionUID = 1L;

		private List<Object> data;
		private long totalCount;
		
		
		
		
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
		
		
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	}