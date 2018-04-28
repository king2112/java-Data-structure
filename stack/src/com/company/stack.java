package com.company;

public class stack {
	private int[] stack = new int[3];
	private int index ;

	stack(){

		index = 3 ;
	}

	private void setStack(int a) {
		this.stack[index-1] = a;
	}

	private int getStack( ) {
		return stack[index];
	}

	private int getIndex() {
		return index;
	}

	private void setIndex(int index) {
		this.index = index;
	}

	public int Push(int a){

		if(getIndex()>0){
			setStack(a);
			setIndex(index -1);
			return 1;
		}
		else {
			System.out.print("stck is full !");
			return 0;
		}
	}
	public int Pop(){

		if(getIndex()<3){
			getStack();
			setIndex(index + 1);
			return 1;
		}
		else {
			System.out.print("stck is empty !");
			return 0;
		}
	}
	public int Top(){

		if(getIndex()<3){
			System.out.print(getStack() + "\n");
			return 1;
		}
		else {
			System.out.print("stck is empty !");
			return 0;
		}
	}
}
