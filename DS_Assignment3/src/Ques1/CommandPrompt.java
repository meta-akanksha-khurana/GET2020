package Ques1;

import java.util.Date;
import java.util.Scanner;

/**
 * This class is used to handle commands of command prompt
 * @author Akanksha
 *
 */
public class CommandPrompt {

	Directory root = new Directory(null, "R", new Date());
	String path = "R:";
	
	/**
	 * This method is used to start command prompt
	 * @param command is command which should be performed
	 */
	public void startCommandPrompt(String command) {
		String[] tokens = command.split(" ", 2);
		String cmd = tokens[0];
		String fileName = null;
		if (tokens.length > 1) {
			fileName = tokens[1];
		}
		switch (cmd) {
		case "mkdir":
			root.mkDir(fileName);
			break;

		case "cd":
			root = root.cd(fileName);
			if(root.getName().equals(fileName))
				path = path + "/" + fileName;
			break;

		case "list": root.list();
			break;

		case "back": root = root.back();
			if(path.indexOf("/") != -1)
				path = path.substring(0,path.lastIndexOf("/"));
			break;

		case "find": root.find(fileName, path);
			break;

		case "tree": root.tree(path);
			break;

		case "exit":
			break;

		default:
			System.out.println("Enter Correct Command.");
		}
	}

	//main method
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CommandPrompt cmpd = new CommandPrompt();
		while (true) {
			System.out.print(cmpd.path + "> ");
			String input1 = input.nextLine();
			cmpd.startCommandPrompt(input1);
			if (input.equals("exit"))
				break;
		}
		input.close();
	}

}