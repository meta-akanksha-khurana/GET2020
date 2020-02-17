package client;
import java.io.*;
import controller.ShoppingCartController;

/**
 * This is the main class fro where the execution starts
 * @author Akanksha
 *
 */
public class Client {

	public static void main(String[] args)throws IOException 
	{
		ShoppingCartController control=new ShoppingCartController();
		control.inputChoice();
	}
}
