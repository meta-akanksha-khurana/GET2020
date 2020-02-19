package com.metacube.rest.dao.impl;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.metacube.rest.pojo.Item;
import com.metacube.rest.utility.*;
import com.metacube.rest.*;

/**
 * This class implements the interface ItemEntity and override its functions
 * @author Akanksha
 *
 */
public class ItemEntity{
	
	DbConnection dbConnection=new DbConnection();

	/**
	 * This function is used to fetch all data from inventory
	 * @throws SQLException
	 */
	public List<Item> getInventory() throws SQLException {
		dbConnection.connect();
		Statement statement = dbConnection.getJdbcConnection().createStatement();
		String query = "Select * from fruits";

		ResultSet resultSet = statement.executeQuery(query);
		
		
		List<Item> inventory = new ArrayList<Item>();
		while(resultSet.next()) {
			Item item = new Item();
			item.setName(resultSet.getString(1));
			item.setQuantity(resultSet.getInt(2));
			inventory.add(item);
		}
		
		statement.close();
		dbConnection.disconnect();
		return inventory;
	}
	

	/**
	 * This function is used to fetch the single item from the inventory
	 * @throws SQLException
	 */
	public Item getItemByName(String itemName) throws SQLException {
		
		dbConnection.connect();
		Statement statement = dbConnection.getJdbcConnection().createStatement();
		String query = "Select * from fruits where name = '"+itemName+"'";
		ResultSet resultSet = statement.executeQuery(query);
		
		Item item = null;
		while(resultSet.next()) {
			item = new Item();
			item.setName(resultSet.getString(1));
			item.setQuantity(resultSet.getInt(2));
		}
		
		
		statement.close();
		dbConnection.disconnect();
		return item;

	}

	/**
	 * This function is used to update the inventory
	 * @throws SQLException
	 */
	public List<Item> updateInventory(List<Item> newInventory) throws SQLException {
		deleteInventory();
		for(Item item : newInventory) {
			addItemToInventory(item);
		}
		return newInventory;
	}
	
	
	/**
	 * This function is used to add single item to the inventory
	 * @throws SQLException
	 */
	public Item addItemToInventory(Item newItem) throws SQLException {
		
		if(getItemByName(newItem.getName()) != null) {
			deleteItemByName(newItem.getName());
		}
		dbConnection.connect();
		PreparedStatement preparedStatement = dbConnection.getJdbcConnection().prepareStatement("insert into fruits values(?,?)");
		preparedStatement.setString(1, newItem.getName());
		preparedStatement.setInt(2, newItem.getQuantity());
		
		if(preparedStatement.executeUpdate()>0) {
			return newItem;
		}
		
		preparedStatement.close();
		dbConnection.disconnect();
		return newItem;
	}

	/**
	 * delete all the items from the inventory
	 * @throws SQLException
	 */
	public void deleteInventory() throws SQLException {
		dbConnection.connect();
		Statement statement = dbConnection.getJdbcConnection().createStatement();
		String query = "delete from fruits";
		statement.execute(query);

		statement.close();
		dbConnection.disconnect();
	}

	/**
	 * This function is  used to delete a single item from inventory
	 * @throws SQLException
	 */
	public void deleteItemByName(String itemName) throws SQLException {
		dbConnection.connect();
		Statement statement = dbConnection.getJdbcConnection().createStatement();
		String query = "delete from fruits where name = '" +itemName+"'";
		statement.execute(query);
		
		statement.close();
		dbConnection.disconnect();

	}	

}
