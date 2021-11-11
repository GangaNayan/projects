package com.practice.Prcatice1.connectio;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author ganganayan.tl
 *
 */
public class ResultSet_To_Object {
	
	
	public static List<Object> convert(ResultSet rs)
	{
		List<Object> oblist=new ArrayList<>();
		try {
			//get column names 
			ResultSetMetaData rsMeta=rs.getMetaData();
			int columnCnt=rsMeta.getColumnCount();
			List<String> columnNames=new ArrayList<>();
			//loop to get All column Names
			for(int i=1; i<=columnCnt; i++) {
				//adding all retrieved column name to List Object
				columnNames.add(rsMeta.getColumnName(i).toLowerCase());
			}
			
			while(rs.next()) {
				//convert each object to an Object 
				Map<String,String> obj=new HashMap<>();
				for(int i=1; i<=columnCnt; i++) {
					String key=columnNames.get(i-1);
					String value=rs.getString(i);
					obj.put(key,value);
				}
				oblist.add(obj);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return oblist;
		
	}
}