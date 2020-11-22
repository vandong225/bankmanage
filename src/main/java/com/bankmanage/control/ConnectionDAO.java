package com.bankmanage.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	private Connection con;
	String dbClass = "com.mysql.jdbc.Driver";
	String dbUrl = "jdbc:mysql://localhost:3306/BankManage";
	String username = "root";
	String password = "123a";
    public ConnectionDAO() {
		con = getConnection(dbClass, dbUrl, username, password);
	}
	public Connection getConnection(String dbClass, String dbUrl, String username, String password){
        Connection conn = null;
            
            try {
            	Class.forName(dbClass);
				conn = DriverManager.getConnection(dbUrl, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        return conn;
    }

}
