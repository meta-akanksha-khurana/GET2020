package Ques2;
import Node.Node;

/**
 * This is the class used to perform loop detection in singly linkedlist
 * @author Akanksha
 *
 */
public class DetectLoop {
	Node head=null;

	/**
	 * This method is used to insert value in linkedlist
	 * @param value is the value to be inserted
	 */
	void insert(int value){
		Node newNode=new Node(value);

		if(head==null){
			head=newNode;
		}
		else{
			Node temp=head;
			while(temp.getNext()!=null){
				temp=temp.getNext();
			}
			temp.setNext(newNode);
		}
	}

	
	/**
	 * This function is used to check if the linked list has loop or not.
	 * @return true if list has loop else false
	 */
	Boolean hasLoop(){
		
		Node temp=this.head;
		while(temp!=null){
			if(temp.getVisited()==0){
				temp.setVisited(1);
			}
			else{
				return true;
			}
			temp=temp.getNext();
		}
		return false;
	}

}
