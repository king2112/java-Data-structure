package com.company;

import java.util.Objects;

public class node {

    public node parent ;
    public   node[] childe= new node[26];
    private int flag ;
    private String mani ;



    node(){


        }



    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setMani(String mani) {
        this.mani = mani;
    }

    public String getMani() {
        return mani;
    }
}


class tree {


    private node root= new node();

    public node getRoot() {
        return root;
    }

    public void addNode(String  word,String mani){
     int sum = 0 ;
        node temp= getRoot();
        for (int i = 0 ; i< word.length() ; i++){

            if (temp.childe[word.charAt(i) - 97] == null) {
                temp.childe[word.charAt(i) - 97] = new node();
                temp.childe[word.charAt(i) - 97].parent = temp;
            }

            temp = temp.childe[word.charAt(i) - 97];
            sum = i ;
        }

     temp.setFlag(1);
     temp.setMani(mani);


       // System.out.print (word+"    added \n");

    }
    public node Search(String word ){
        node temp = root ;
        int i = 0 ;
        while (temp.childe[word.charAt(i) - 97]!= null){

            temp = temp.childe[word.charAt(i) - 97];
            i++;
            if(i==word.length()){
                break;
            }

        }
     if (temp.getFlag()==1){
            System.out.print("Defenition is  :   "+temp.getMani()+"\n");
            return temp;
     }
    System.out.print(word+"    Not found !\n");
       return null;
    }
    public node SearchDel(String word ){
        node temp = root ;
        int i = 0 ;
        while (temp.childe[word.charAt(i) - 97]!= null){

            temp = temp.childe[word.charAt(i) - 97];
            i++;
            if(i==word.length()){
                break;
            }

        }
        if (temp.getFlag()==1){
           // System.out.print("Defenition is  :   "+temp.getMani()+"\n");
            return temp;
        }
        System.out.print(word+"    Not found !\n");
        return null;
    }

    public int Delet(String word){

    node temp  = SearchDel(word);
    node temp1 ;
    if (temp==null) {
        System.out.print("not Found");
        return 0 ;
    }
        boolean isleaf = true;
    int index = 0 ;
   do {





       for (int i = 0; i < 26; i++) {
           if (temp.childe[i] != null) {
               isleaf = false;
               System.out.print(word+"    deleted\n");
               return  0 ;
           }
       }
       temp.setFlag(0);

        temp1=temp.parent;
       temp1.childe[(word.charAt(word.length()-index-1))-97]=null;
       temp = temp1;
       index++;
   }while (temp != root && isleaf && temp.getFlag() != 1);

    System.out.print(word+"    deleted\n");
    return 1;

    }



}