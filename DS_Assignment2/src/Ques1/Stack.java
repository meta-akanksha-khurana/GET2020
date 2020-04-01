package Ques1;

/**
 * This is the class used to represent stack
 * It implements IStack interface
 * @author Akanksha
 *
 */
public class Stack implements IStack {
	String array[];
	int top;

	/**
	 * Constructor to create stack
	 * @param size represents size of stack
	 */
	Stack(int size){
		array=new String[size];
		top=-1;
	}

	/**
	 * This method is used to push elements in the stack
	 * It override push method of IStack interface
	 * @throws assertion error if stack is full
	 */
	@Override
	public void push(String value) {
		if(top==array.length-1){
			throw new AssertionError("Can't insert.Stack is full.");
		}
		else{
			array[++top]=value;
		}

	}

	/**
	 * This method is used to pop elements from the stack
	 * It override pop method of IStack interface
	 * @throws assertion error if stack is empty
	 */
	@Override
	public String pop() {
		if(top==-1){
			throw new AssertionError("Can't delete.Stack is empty");
		}
		else{
			return array[top--];
		}

	}

	/**
	 * This method is used to get value at top in stack
	 * It override peek method of IStack interface
	 */
	@Override
	public String peek() {
		return array[top];
	}


	/**
	 * This method is used to check if stack is empty or not
	 * @return true if stack is empty else false
	 */
	public Boolean isEmpty(){
		if(top==-1){
			return true;
		}
		else {
			return false;
		}
	}

}
