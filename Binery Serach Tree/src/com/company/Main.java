package com.company;

public class Main {

	public static void main(String[] args) {

		binerytree thetree = new binerytree();
		thetree.AddNode(50, "boss");
		thetree.AddNode(20 , "boss1");
		thetree.AddNode(30 , "boss2");
		thetree.AddNode(70 , "boss3");
		thetree.AddNode(80 , "boss4");
		//thetree.inOrederTraverse(thetree.root);
		//System.out.println(thetree.findNode(30));
		thetree.remove(30);
		thetree.inOrederTraverse(thetree.root);



	}
}
