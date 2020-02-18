package com.metacube.rest.pojo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is the pojo class containing attributes and getter & setter methods for the item
 * @author Akanksha
 *
 */
@XmlRootElement
public class Item {
	
	String name;
	int quantity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
