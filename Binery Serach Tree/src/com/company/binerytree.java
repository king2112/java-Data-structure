package com.company;

public class binerytree {
	node root;

	public int AddNode(int key, String value) {
		node newNode = new node(key, value);
		if (root == null) {

			root = newNode;

		} else {
			node tempNode = root;
			while (true) {

				node parent = tempNode;

				if (key < tempNode.value) {
					tempNode = tempNode.leftChild;
					if (tempNode == null) {
						parent.leftChild = newNode;
						return 1;
					}

				} else {
					if (key > tempNode.value) {
						tempNode = tempNode.rightChild;
						if (tempNode == null) {
							parent.rightChild = newNode;
							return 1;
						}
					}
				}
			}


		}


		return 0;
	}

	public void inOrederTraverse(node tempNode) {


		if (tempNode != null) {
			inOrederTraverse(tempNode.leftChild);
			System.out.println(tempNode);
			inOrederTraverse(tempNode.rightChild);

		}
	}

	public node findNode(int value) {
		node tempNode = root;
		while (tempNode.value != value) {
			if (value < tempNode.value) {
				tempNode = tempNode.leftChild;
			} else {
				tempNode = tempNode.rightChild;
			}
			if (tempNode == null) {
				System.out.println("ithem not found ");
				return null;
			}
		}
		return tempNode;
	}


	public boolean remove(int value) {
		node temNode = root;
		node parent = root;

		boolean isItTheLeftChild = true;

		while (value != temNode.value) {

			parent = temNode;

			if (value < temNode.value) {
				isItTheLeftChild = true;
				temNode = temNode.leftChild;

			} else {
				isItTheLeftChild = false;
				temNode = temNode.rightChild;

			}
			if (temNode == null) {
				System.out.print("ithem not found !");
				return false;
			}
		}

			if (temNode.leftChild == null && temNode.rightChild == null) {
				if (temNode == root) {
					root = null;
				} else if (isItTheLeftChild) {
					parent.leftChild = null;
				} else {
					parent.rightChild = null;
				}
			} else if (temNode.rightChild == null) {
				if (temNode == root) {
					root = temNode.leftChild;
				} else if (isItTheLeftChild) {
					parent.leftChild = temNode.leftChild;
				} else {
					parent.rightChild = temNode.leftChild;
				}
			} else if (temNode.leftChild == null) {
				if (temNode == root) {
					root = temNode.rightChild;
				} else if (isItTheLeftChild) {
					parent.leftChild = temNode.rightChild;
				} else {
					parent.rightChild = temNode.rightChild;
				}

			} else {
				node replacemenet = getReplacementNode(temNode);
				if (temNode == root) {
					root = replacemenet;
				} else if (isItTheLeftChild) {
					parent.leftChild = replacemenet;
				} else {
					parent.rightChild = replacemenet;
					replacemenet.leftChild = temNode.leftChild;
				}

			}




		return true;
	}

	public node getReplacementNode(node replacedNode) {


		node replacementParent = replacedNode;

		node replacement = replacedNode;


		node focusNode = replacedNode.rightChild;


		while (focusNode != null) {

			replacementParent = replacement;

			replacement = focusNode;

			focusNode = focusNode.leftChild;

		}


		if (replacement != replacedNode.rightChild) {

			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;

		}

		return replacement;

	}

}


class node {

	int value;
	String name;

	node rightChild;
	node leftChild;

	node(int value, String Name) {

		this.value = value;
		this.name = Name;

	}

	public String toString() {
		return (name + " has key :" + this.value);
	}


}