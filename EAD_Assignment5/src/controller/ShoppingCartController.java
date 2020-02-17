package controller;

import java.io.*;

import view.*;
import model.*;
import facade.*;

import java.util.*;

/**
 * This is the controller class for performing operations on Shopping cart
 * @author Akanksha
 *
 */
public class ShoppingCartController {

	/**
	 * This function is used to select operation to perform on shopping cart
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void inputChoice() throws NumberFormatException, IOException {

		int choice,choice2,quantity1,quantity3,quantity5;
		HashMap<Integer,Product> allProductsFacade=new HashMap<Integer,Product>();
		Scanner input=new Scanner(System.in);
		CartFacade facade=new CartFacade();

		while(true)
		{

			MenuView menu=new MenuView();
			menu.displayMenu();
			choice=input.nextInt();
			switch(choice)
			{
			case 1:
				allProductsFacade=facade.ProductListFacade(); 

				Products allproducts=new Products();
				allproducts.displayProducts(allProductsFacade);
				break;


			case 2:
				MenuView itemMenu=new MenuView();
				itemMenu.itemMenu();
				choice2=input.nextInt();
				switch(choice2)
				{
				case 1:MenuView quantity=new MenuView();
				quantity.askQuantity();
				quantity1=input.nextInt();
				Product product =new Product("Furniture","chair",200,quantity1);
				facade.addProductFacade(product);
				break;

				case 2:MenuView quantity2=new MenuView();
				quantity2.askQuantity();
				quantity3=input.nextInt();
				Product product2 =new Product("Furniture","table",500,quantity3);
				facade.addProductFacade(product2);
				break;

				case 3:MenuView quantity4=new MenuView();
				quantity4.askQuantity();
				quantity5=input.nextInt();
				Product product3 =new Product("Furniture","bed",1000,quantity5);
				facade.addProductFacade(product3);
				break;
				default:
					System.out.println("Enter valid choice!!");
				}
				break;


			case 3:
				MenuView itemMenu1=new MenuView();
				itemMenu1.itemMenu();
				choice2=input.nextInt();
				switch(choice2)
				{
				case 1:
					MenuView quantity=new MenuView();
					quantity.askQuantity();
					quantity1=input.nextInt();
					Product product =new Product("Furniture","chair",200,quantity1);
					facade.removeProductFacade(product);
					break;
				case 2:
					MenuView quantity2=new MenuView();
					quantity2.askQuantity();
					quantity3=input.nextInt();
					Product product2 =new Product("Furniture","table",200,quantity3);
					facade.removeProductFacade(product2);
					break;

				case 3:
					MenuView quantity4=new MenuView();
					quantity4.askQuantity();
					quantity5=input.nextInt();
					Product product3 =new Product("Furniture","bed",1000,quantity5);
					facade.removeProductFacade(product3);
					break;
				}
				break;

			case 4:
				List<Product> cartProducts=new ArrayList<Product>();
				cartProducts=facade.viewCart();
				ShoppingCartView view=new ShoppingCartView();
				view.displayShoppingCart(cartProducts);
				break;
				
			case 5:
				int bill=facade.bill();
				ShoppingCartView billView=new ShoppingCartView();
				billView.displayBill(bill);				
				break;
				
			case 6:
				System.exit(0);
				
			default:
				System.out.println("Enter valid choice!!");
				break;
			}
		}
		
	}
}


