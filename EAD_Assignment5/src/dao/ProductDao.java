package dao;

import model.Product;

import java.util.*;

/**
 * This is the DAO class used to perform operations on product
 * @author Akanksha
 *
 */
public class ProductDao {
	
	//stores the id and details of a Product
	private HashMap <Integer,Product> allProducts=new HashMap<>();
	int id=1;
	
	/**
	 * Public constructor used to initialize the DAO class
	 */
	public ProductDao()
	{
			add(new Product("Furniture","chair",200,10));
			add(new Product("Furniture","table",500,10));
			add(new Product("Furniture","bed",1000,10));	
	}
	
	
	/**
	 * Function to add Product in the store
	 * @param product is object of Product class
	 */
	void add(Product product)
	{
		allProducts.put(id,product);
		product.setProductCode(id);
		id++;
	}
	
	/**
	 * This function returns the products available in store 
	 * @return products available in store in hashmap
	 */
	public HashMap<Integer,Product> ProductList()
	{
		return allProducts;
	}
	
	/**
	 * This function is used to delete quantity of product from store
	 * @param product is object of Product class
	 */
	public void deleteQuantity(Product product)
	{
		for(Map.Entry<Integer, Product> m:allProducts.entrySet()){
			if(m.getValue().getName().equals(product.getName())){
				int id=m.getKey();
				allProducts.replace(id,new Product(allProducts.get(id).getType(),allProducts.get(id).getName(),allProducts.get(id).getPrice(),allProducts.get(id).getQuantity()-product.getQuantity() ));
			}
		}
	}
	
	
	/**
	 * This function is used to add quantity of product from store
	 * @param product is object of Product class
	 */
	public void addQuantity(Product product)
	{
		for(Map.Entry<Integer, Product> m:allProducts.entrySet()){
			if(m.getValue().getName().equals(product.getName())){
				int id=m.getKey();
				allProducts.replace(id,new Product(allProducts.get(id).getType(),allProducts.get(id).getName(),allProducts.get(id).getPrice(),allProducts.get(id).getQuantity()+product.getQuantity() ));
			}
		}
	}
	
	
}
