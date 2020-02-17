package facade;
import dao.*;

import java.util.*;

import model.*;

/**
 * This is the class for facade layer
 * @author Akanksha
 *
 */
public class CartFacade {

		HashMap <Integer,Product> productList=new HashMap<>();
	    ShoppingCartDao cart=new ShoppingCartDao();
	    ProductDao productdao = null;
	    
	    public CartFacade () {
	    	productdao = cart.getProductDao();
	    }
	    
	    /**
	     * This function returns the list of products in store
	     * @return
	     */
	    public HashMap<Integer,Product> ProductListFacade()
		{
			productList=productdao.ProductList();
			return productList;
		}
		
	    /**
	     * This function is used to add product in cart
	     * @param product
	     */
		public void addProductFacade(Product product)
		{
			
			cart.addProduct(product);
		}
		
		/**
		 * This function is used to remove product from cart
		 * @param product
		 */
		public void removeProductFacade(Product product)
		{
			cart.removeProduct(product);
		}
		
		/**
		 * This function is used to return cart items
		 * @return list of products in cart
		 */
		public List<Product> viewCart()
		{
			List<Product> products=new ArrayList<Product>();
			products=cart.sendCart();
			return products;
		}
		
		/**
		 * This function is used to generate bill
		 * @return bill in integer format
		 */
		public int bill()
		{
			List<Product> billProducts=new ArrayList<Product>();
			billProducts=viewCart();
			int bill=0;
			for(int i=0;i<billProducts.size();i++)
			{
				bill+=billProducts.get(i).getQuantity()*billProducts.get(i).getPrice();
			}
			return bill;
		}
		
}

