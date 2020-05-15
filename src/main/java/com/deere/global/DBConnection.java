package com.deere.global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.deere.global.GlobalThings.*;

public class DBConnection {
	private static Connection connection;
	private static Statement statement;
	private static int resultSet;
	private static ResultSet result;
	
	/**
	 * Method to open DB connection 
	 */
	public static void openConnection(String environment){ 
		try {
			Class.forName("COM.ibm.db2os390.sqlj.jdbc.DB2SQLJDriver");
			if (environment.equalsIgnoreCase("CERT")){
				connection = DriverManager.getConnection(serverName_CERT,dbUserName,dbPassWord);
			}
			else if (environment.equalsIgnoreCase("QUAL")){
				connection = DriverManager.getConnection(serverName_QUAL,dbUserName,dbPassWord);
			}
			else if (environment.equalsIgnoreCase("QUAL2")){
				connection = DriverManager.getConnection(serverName_QUAL,dbUserName,dbPassWord);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void openHANAConnection(InputEnvironmentDetails inputEnvDetails){ 
		try {
			if(inputEnvDetails.getEnvironment().equals("QUAL"))
			connection = DriverManager.getConnection(hanaserverName_QUAL,hanadbUserName,hanadbPassWord);
			else  if(inputEnvDetails.getEnvironment().equals("QUAL2"))
				connection = DriverManager.getConnection(hanaserverName_QUAL,hanadbUserName,hanadbPassWord);
			else
				connection = DriverManager.getConnection(hanaserverName_CERT, hanadbUserName, hanadbPassWord);
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
	}
	
	/**
	 * Method to get the ResultSet object on providing SQL query
	 * @param sql
	 * @return ResultSet
	 */
	public static int getResultSet(String sql) {
		try {
			statement = connection.createStatement();
			resultSet = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet executeQuery(String sql) {
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void deleteOrUpdateRecord(String sql){
		try (Statement statement =  connection.createStatement()){
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to close the connection
	 * 
	 */
	public static void closeConnection() {
		try {
			if (statement != null) {statement.close();}
			if (connection != null) {connection.close();}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}