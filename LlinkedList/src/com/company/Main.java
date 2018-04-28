package com.company;

public class Main {

    public static void main(String[] args) {


        LinkedList list = new LinkedList();

        list.addAtTail("hassan");
        list.addAtTail("hossein");
        list.addAtTail("ali");
        list.addAtHead("hesam");
        list.deleteAtName("hesam");
        list.printList() ;

    }
}
