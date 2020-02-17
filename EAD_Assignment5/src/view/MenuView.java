package view;

/**
 * This is the class used to display menus
 * @author Akanksha
 *
 */
public class MenuView {
	
	public void displayMenu()
	{
		System.out.println();
		System.out.println("1. To see the items which are present in the store");
		System.out.println("2. Add a product in the cart");
		System.out.println("3. Remove a product from the cart");
		System.out.println("4. See your shopping cart");
		System.out.println("5. Generate bill");
		System.out.println("6. Exit from the store");		
	}
	
	public void itemMenu()
	{
		System.out.println("Enter 1 if you want to select chair");
		System.out.println("Enter 2 if you want to select table");
		System.out.println("Enter 3 if you want to select bed");
	}
	
	public void askQuantity()
	{
		System.out.println("Enter the quantity");
	}

}
