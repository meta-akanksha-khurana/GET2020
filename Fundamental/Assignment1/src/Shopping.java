/**
 * 
 *      Assignment 1
 */
import java.util.*;
class Item{
	String Name;
	double price;
	int stock;

	Item(String Name,double price,int stock)
	{
		this.Name=Name;
		this.price=price;
		this.stock=stock;
	}
}
public class Shopping{
	HashMap <Integer,Item> items=new HashMap<>();//stores the id and details of an item
	int id=1;
	
	Shopping()
	{
		add(new Item("Egg",20.00,30));
		add(new Item("Bread",30.00,10));
		add(new Item("Butter",40.00,20));	
	}
	
	//Function to add item in the store
	void add(Item i)
	{
		items.put(id,i);
		id++;
	}
	
	//Function to display items in store
	void display()
	{
		System.out.println("ID"+" "+"Name"+" "+"Quantity");
		for(Map.Entry<Integer, Item> m:items.entrySet())
			System.out.println(m.getKey()+" "+m.getValue().Name+" "+m.getValue().price+" "+m.getValue().stock);
	}

	class Cart
	{
		HashMap<Integer,Integer> purchaseItem=new HashMap<>();//stores the id and quantity of an item
		Scanner sc=new Scanner(System.in);
		
		//Function to add item in the cart
		public void addItem()
		{
			System.out.println("Add the items from the following");
			display();
			System.out.println("Enter the id of item:");
			int id=sc.nextInt();
			System.out.println("Enter quantity of item:");
			int quantity=sc.nextInt();
			purchaseItem.put(id,quantity);
			items.replace(id,new Item(items.get(id).Name,items.get(id).price,items.get(id).stock-quantity ));
		}
		
		//Function to delete item from the cart
		public void deleteItem()
		{
			show();
			System.out.println("Ënter the id of item to delete:");
			int id1=sc.nextInt();
			System.out.println("Enter the quantity of item to delete:");
			int quantity1=sc.nextInt();
			double rev_quantity=purchaseItem.get(id1)-quantity1;
			if(rev_quantity >0)
				purchaseItem.replace(id1, purchaseItem.get(id1)-quantity1);
			else if(rev_quantity==0)
				purchaseItem.remove(id1);
			else
				System.out.println("Enter a valid quantity!!");
			
			items.replace(id1,new Item(items.get(id1).Name,items.get(id1).price,items.get(id1).stock+quantity1 ));
		}
		
		//Function to show items in the cart
		public void show() 
		{
			System.out.println("ID"+" "+"Name"+" "+"Quantity");
			for(Map.Entry<Integer, Integer> m:purchaseItem.entrySet())
			    System.out.println(m.getKey()+"  "+items.get(m.getKey()).Name+"  "+m.getValue());
		}
		
		//Function to generate bill
		public void generateBill()
		{
			double total=0;
			for(Map.Entry<Integer,Integer> m:purchaseItem.entrySet())
			{
				total+=m.getValue()*items.get(m.getKey()).price;
			}
			System.out.println("Total Bill:"+total);
		}
	}
	
	
	public static void main(String[] args) {
		Shopping.Cart c=new Shopping().new Cart();
		Scanner sc=new Scanner(System.in);
		String ans;
		Boolean option;
		do
		{
			
			System.out.println("1. Add Items to cart");
			System.out.println("2. Delete Items from cart");
			System.out.println("3. Show Items in cart");
			System.out.println("4. Generate Bill");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:
					c.addItem();
					break;	
				case 2:
					c.deleteItem();
					break;
				case 3:
					c.show();
					break;
					
				case 4:
					c.generateBill();
					break;
					
				case 5:
					System.exit(0);
					
				default:
					System.out.println("Enter valid choice!!");
					break;
			}
			System.out.print("Do you want to continue??(YES/NO)");
			ans=sc.next();
			
			if(ans.equalsIgnoreCase("yes"))
				option=true;
			else
				option=false;

		}while(option);
		sc.close();
	}

}
