package com.company;

public class LinkedList {

	Node first;

	LinkedList() {
		Node first = null;
	}

	public int addAtTail(String name) {

		Node temp = first;
		if (first == null) {
			first = new Node(name);

			return 1;

		} else {

			while (temp.nextNode != null) {
				temp = temp.nextNode;
			}
			temp.nextNode = new Node(name);

			return 1;
		}


	}

	public int printList() {
		Node temp = first;
		int i = 0;
		while (temp != null) {
			System.out.print(i + " - " + temp.name + "\n");
			i++;
			temp = temp.nextNode;
		}
		return 1;
	}

	public int deleteAtName(String name) {

		Node temp = first;
		Node beforeTemp = first;
		if (temp == null) {
			System.out.print("list is empty !");
			return 0;
		}else if (first.name == name){
			first = first.nextNode ;
			return 1;
		}
		else {
			while (temp.name != name) {
				beforeTemp = temp;
				temp = temp.nextNode;
			}
			beforeTemp.nextNode = temp.nextNode;
			System.out.print("ithem removed !\n");
			return 1;

		}
	}

	public Node searchNode(String name) {
		Node temp = first;


		if (temp == null) {
			System.out.print("list id=s empty !");
			return null;
		} else {
			while (temp.nextNode.name != name) {
				temp = temp.nextNode;
			}
			return temp;

		}

	}

	public int addAtIndex(int index , String name){

		Node temp = first;
		Node beforeTemp = first;
		int i = 0 ;

		while (i !=index){
			beforeTemp=temp;
			temp =temp.nextNode ;
			i++ ;

		}
		beforeTemp.nextNode=new Node(name);
		beforeTemp.nextNode.nextNode=temp;
		return 1;

	}

	public int addAtHead(String  name){

		Node temp = first ;
		first = new Node(name);
		first.nextNode = temp ;
		return 1;
	}


}


class Node {


	String name;
	Node nextNode;

	Node(String name) {
		this.name = name;
	}


}