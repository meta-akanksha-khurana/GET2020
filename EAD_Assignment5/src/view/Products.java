package view;


import java.util.*;

import model.*;

public class Products {
		
	public void displayProducts(HashMap<Integer,Product> allProductsList)
	{
			System.out.println("ID"+" "+"Name"+" "+"Price"+" "+"Quantity");
			for(Map.Entry<Integer, Product> m:allProductsList.entrySet())
				System.out.println(m.getKey()+" "+m.getValue().getName()+" "+m.getValue().getPrice()+" "+m.getValue().getQuantity());	
	}
}
