package Ques1;
import java.util.Scanner;

import Node.Node;

/**
 * This class is used to represent linked list and its operations
 * @author Akanksha
 *
 */
public class LinkList {
	Node head=null;
	int size=0;

	
	/**
	 * This method is used to insert node in a linked list
	 * @param value
	 */
	void insert(int value){
		Node newNode=new Node(value);

		if(head==null){
			head=newNode;
			size++;
		}
		else{
			Node temp=head;
			while(temp.getNext()!=null){
				temp=temp.getNext();
			}
			temp.setNext(newNode);
			size++;
		}
	}

	
	/**
	 * This method is used to create sublist of the given list
	 * @param leftIndex is index of list from left
	 * @param rightIndex is index of list from right
	 * @return sublist
	 */
	LinkList subList(int leftIndex,int rightIndex){
		LinkList newList=new LinkList();
		Node temp=this.head;
		int count=1;
		while(temp!=null){
			if(count >= leftIndex && count <= rightIndex ){
				newList.insert(temp.getValue());
			}
			temp=temp.getNext();
			count++;
		}
		return newList;
	}

	
	/**
	 * This method is used to rotate the list clockwise. 
	 * @param numberOfRotations is the number of rotations by which list is rotated
	 * @return rotated list
	 */
	LinkList rotate(int numberOfRotations){
		while(numberOfRotations!=0){
			Node temp=this.head;
			while(temp.getNext()!=null){
				temp=temp.getNext();
			}
			temp.setNext(head);
			head=head.getNext();
			temp.getNext().setNext(null);
			numberOfRotations--;
		}
		
		return this;
	}
	
	
	/**
	 * This method is used to modify the list
	 * @param leftIndex is index from left side for sublist
	 * @param rightIndex is index from right side for sublist
	 * @param numberOfRotations
	 * @return true if list is modified else false
	 */
	Boolean modifyList(int leftIndex,int rightIndex,int numberOfRotations){
		if(head == null || rightIndex < leftIndex || this.size < leftIndex || this.size < rightIndex || leftIndex==rightIndex ){
			return false;
		}
		LinkList sublist=this.subList(leftIndex, rightIndex);
		LinkList rotatedList=sublist.rotate(numberOfRotations);
		Node temp1=this.head;
		Node temp2=rotatedList.head;
		int count=1;
		
		while(temp1!=null&&temp2!=null){
			if(count>=leftIndex && count<=rightIndex){
				temp1.setValue(temp2.getValue());
				temp2=temp2.getNext();
			}
			temp1=temp1.getNext();
			count++;
		}
		return true;
	}
}
