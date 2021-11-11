package com.practice.Prcatice1.Dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.practice.Prcatice1.connectio.ConnectFactory;
import com.practice.Prcatice1.connectio.ResultSet_To_Object;
import com.practice.Prcatice1.controller.GenericQueryCreationController;
import com.practice.Prcatice1.model.GenericQueryCreationDTO;
import com.practice.Prcatice1.model.GenericQueryCreationResultDTO;

@Repository
public class SupplierRiskDataRepositoryimpl implements SupplierRiskDataRepository {
	
	private static final Logger	LOGGER	= LoggerFactory.getLogger(SupplierRiskDataRepositoryimpl.class);
	
	@Autowired
	public Environment environment;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * 
	 * @author ganganayan.tl
	 *
	 */
	@Override
	public GenericQueryCreationResultDTO getGenericQueryResult(GenericQueryCreationDTO genericQueryCreationDTO) {
		
		GenericQueryCreationResultDTO genericQueryCreationResultDTO=new GenericQueryCreationResultDTO();
		
		String squery=genericQueryCreationDTO.getQuery();
		long startIndex=genericQueryCreationDTO.getStartIndex();
		long endIndex=genericQueryCreationDTO.getEndIndex();
		long limit=endIndex-startIndex;
		
	   // String query=squery+" limit "+endIndex+" offset "+startIndex+"";
	   //for postgresSql use this  String query=squery+" limit "+limit+" offset "+startIndex+"";
		//for mysql use below
		String testquery=squery;
	    
	    try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	    
	    String dbUserName=environment.getProperty("spring.datasource.username");
	    String dbUrl=environment.getProperty("spring.datasource.url");
	    String dbPassword=environment.getProperty("spring.datasource.password");
	    
		try(Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
				PreparedStatement pst=con.prepareStatement(testquery);ResultSet rs =pst.executeQuery();){
			//for postgresSql use this PreparedStatement pst=con.prepareStatement(query);ResultSet rs =pst.executeQuery();){
			
			List<Object> oblist=ResultSet_To_Object.convert(rs);
			
			genericQueryCreationResultDTO.setData(oblist);
			//for postgresSql use this genericQueryCreationResultDTO.setTotalCount(getGenericQueryCount(squery));
			//for mysql use below
			genericQueryCreationResultDTO.setTotalCount(getGenericQueryCount(testquery));
			
		} catch (Exception e) {
			LOGGER.error("Error in processing",e);
			StringWriter sw=new StringWriter();
			PrintWriter pw=new PrintWriter(sw);
			e.printStackTrace(pw);
			pw.flush();
			genericQueryCreationResultDTO.setErrorStackTrace(sw.toString());
		}
		
		return genericQueryCreationResultDTO;
		
	}
	
	public long getGenericQueryCount(String squery) {
		
		String fquery="select count(*) from ("+squery+") tmp";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	    
	    String dbUserName=environment.getProperty("spring.datasource.username");
	    String dbUrl=environment.getProperty("spring.datasource.url");
	    String dbPassword=environment.getProperty("spring.datasource.password");
	    
	    int totalCount=0;
		try(Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
				PreparedStatement pst=con.prepareStatement(fquery); ResultSet rs=pst.executeQuery()){	
			while(rs.next()) {
				totalCount=rs.getInt(1);
			}
		} catch (Exception e) {
			LOGGER.error("Error in processing",e);
		}
		
		return totalCount;
	}
}
