/**
 * 用链表的方式实现栈
 */
package cmpbookcoder.datastruct;

public class MyStackL<E> {
       class Node<E>{
	     Node<E> next=null;
	     E data;
	     public Node(E data){
	    	 this.data=data;
	     }
       }
     Node<E> top=null;
     public boolean isEmpty(){
    	 return top==null;
     }
     public void push(E data){
    	 Node<E> newnode=new Node<E>(data);
    	 newnode.next=top;
    	 top=newnode;
     }
     public E pop(){
    	 if(isEmpty()){
    		 return null;
    	 }
    	 E data=top.data;
    	 top=top.next;
    	 return data;
     }
     public E peek(){
    	 if(isEmpty()){
    		 return null;
    	 }
    	 return top.data;
     }
}
