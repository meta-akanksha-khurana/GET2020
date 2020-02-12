package com.metacubeParkingDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public DbConnection(){
		this.jdbcURL="jdbc:mysql://localhost:3306/parkingsystem";
		this.jdbcUsername="root";
		this.jdbcPassword="root";
	}
	
	
	public void connect() throws SQLException {
		if (getJdbcConnection() == null || getJdbcConnection().isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		
	}
	
	
	public void disconnect() throws SQLException {
		if (getJdbcConnection() != null && !getJdbcConnection().isClosed()) {
			jdbcConnection.close();
		}
	}


	public Connection getJdbcConnection() {
		return jdbcConnection;
	}


	/*public void setJdbcConnection(Connection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}*/

}
