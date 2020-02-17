package view;
import model.*;

import java.util.*;

/**
 * This class is used as view for Shopping cart
 * @author Akanksha
 *
 */
public class ShoppingCartView {
	
	/**
	 * This function is used to display shopping cart
	 * @param cartProducts. Products present in cart
	 */
	public void displayShoppingCart(List<Product> cartProducts)
	{
		System.out.println("Name"+" "+"Quantity");
		for(int i=0;i<cartProducts.size();i++)
		{
			if(cartProducts.get(i).getQuantity()>0){
				System.out.println(cartProducts.get(i).getName()+"   "+cartProducts.get(i).getQuantity());
			}
		}
	}
	
	/**
	 * This function is used to display bill
	 * @param bill
	 */
	public void displayBill(int bill)
	{
		System.out.println("Your bill is: Rs."+bill);
	}
	
}
