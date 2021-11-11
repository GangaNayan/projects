package com.practice.Prcatice1.connectio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectFactory {
    private static Connection con;
    static {
    	try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    public static Connection getConnection() {
    	return con;
    }
    
    public static void close() {
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
