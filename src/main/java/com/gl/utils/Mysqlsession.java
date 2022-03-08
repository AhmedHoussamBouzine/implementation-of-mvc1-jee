 package com.gl.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Mysqlsession {
	 private static Mysqlsession mysqlsession ;
	 private Connection connection; 
	 private String url = "jdbc:mysql://localhost:3306/EtudiantOption";
	 private  String user = "root";
	 private String pass = "";
	 private Mysqlsession() {
		
		 try{
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    connection = DriverManager.getConnection(url, user, pass);
			    
           }
				catch(Exception e){
				e.printStackTrace();  
           }
		
   }
	 
	 public static Mysqlsession getInstance() {

				if(mysqlsession == null)
                      mysqlsession = new Mysqlsession();
			
		return mysqlsession;
		 
	 }
	
	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		try {
			
			if(connection == null || connection.isClosed())
			connection = DriverManager.getConnection(url, user, pass);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
	}
	/**
	 * @param con the con to set
	 */
	public void setConnection(Connection connnection) {
		this.connection = connnection;
	}
	
	
}


