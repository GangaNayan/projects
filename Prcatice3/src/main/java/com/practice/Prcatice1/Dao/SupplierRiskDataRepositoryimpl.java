package com.practice.Prcatice1.Dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.practice.Prcatice1.connectio.ConnectFactory;
import com.practice.Prcatice1.connectio.ResultSet_To_Object;
import com.practice.Prcatice1.model.GenericQueryCreationDTO;
import com.practice.Prcatice1.model.GenericQueryCreationResultDTO;

@Repository
public class SupplierRiskDataRepositoryimpl implements SupplierRiskDataRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public GenericQueryCreationResultDTO getGenericQueryResult(GenericQueryCreationDTO genericQueryCreationDTO) {
		
		GenericQueryCreationResultDTO genericQueryCreationResultDTO=new GenericQueryCreationResultDTO();
		
	    String query=genericQueryCreationDTO.getQuery();
	    
		
		try {
			Connection con=ConnectFactory.getConnection();
			Statement st=con.createStatement();
		
			ResultSet rs =null;
			try {
			rs=st.executeQuery(query);
			}catch (Exception e) {
				StringWriter sw=new StringWriter();
				PrintWriter pw=new PrintWriter(sw);
				e.printStackTrace(pw);
				pw.flush();
				genericQueryCreationResultDTO.setErrorStackTrace(sw.toString());
			}
			
			List<Object> oblist=ResultSet_To_Object.convert(rs);
			long t=ResultSet_To_Object.tcount;
			
			ResultSet rs1=st.executeQuery("select count(*) from emp1");
			rs1.next();
			long c=rs1.getInt(1);
			
			genericQueryCreationResultDTO.setColclass(oblist);
			genericQueryCreationResultDTO.setTotalCount(t);
			
			//jdbcTemplate.query("select count(*) from emp1", new RowMapper);
			
		} catch (Exception e) {
			
		}
		ConnectFactory.close();
		return genericQueryCreationResultDTO;
		
	}
	
	public long total() {
		long c = 0;
		try {
			System.out.println("ganaga ok 1");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","tiger");
			System.out.println("ganaga ok 2");
			Statement st=con.createStatement();
			System.out.println("ganaga ok 3");
			//ResultSet rs=st.executeQuery(

//			
			ResultSet rs=st.executeQuery("select count(*) from emp1");
			rs.next();
			c=rs.getInt(1);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return c;
	}

}
