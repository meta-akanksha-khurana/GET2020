package dao;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Product;
import dao.ProductDao;

/**
 * This is the DAO class used to perform operations on shopping cart
 * @author Akanksha
 *
 */
public class ShoppingCartDao {
	
	ProductDao productDao=new ProductDao();
	private List<Product> products=new ArrayList<Product>();
	
	/**
	 * This function is used get the object of ProductDao class
	 * @return object of ProductDao class
	 */
	public ProductDao getProductDao() {
		return productDao;
	}
	
	
	/**
	 * This function is used to add product in the cart
	 * @param product is object of Product class
	 */
	public void addProduct(Product product)
	{
		int flag=0;
		for(int i=0;i<products.size();i++)
		{
			if(products.get(i).getName().equals(product.getName()))
			{
				flag=1;
				products.get(i).setQuantity(products.get(i).getQuantity()+product.getQuantity());
				productDao.deleteQuantity(product);
				break;
			}
		}
		if(flag==0){
			products.add(product);
			productDao.deleteQuantity(product);
		}
	}
	
	
	/**
	 * This function is used to remove product in the cart
	 * @param product is object of Product class
	 */
	public void removeProduct(Product product)
	{
		int flag=0;
		for(int i=0;i<products.size();i++)
		{	
			if(products.get(i).getName().equals(product.getName()))
			{
				int rev_quantity=products.get(i).getQuantity()-product.getQuantity();
				if(rev_quantity >0){
					flag=1;
					products.get(i).setQuantity(products.get(i).getQuantity()-product.getQuantity());
					System.out.println("hiii");
					productDao.addQuantity(product);
					break;
				}
				else if(rev_quantity==0){
					products.remove(i);
					productDao.addQuantity(product);
				}
				else
					System.out.println("Enter a valid quantity!!");
				
			}
		}
		
		if(flag==0)
			products.remove(product);
	}
	
	/**
	 * This function returns the products in cart
	 * @return list of products present in cart
	 */
	public List<Product> sendCart()
	{
		return products;
	}
	
}
