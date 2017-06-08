package cmpbookcoder;
import java.util.*;
/* Java 实现排序二叉树的前序、中序、后序遍历
 * 递归版本*/
class Node{
	public int data;
	public Node left;
	public Node right;
	public Node(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
public class BinaryTree {
    private Node root;
    public BinaryTree(){
    	root=null;
    }
    //将data插入到排序二叉树中
    public void insert(int data){
    	Node newnode=new Node(data);
    	if(root==null){
    		root=newnode;
    	}else{
    		Node curnode=root;
    		Node parent;
    		//寻找插入的位置
    		while(true){
    			parent =curnode;
    			if(data<curnode.data){
    				curnode=curnode.left;
    				if(curnode==null){
    					parent.left=newnode;
    					return;
    				}
    			}else{
    				curnode=curnode.right;
    				if(curnode==null){
    					parent.right=newnode;
    					return;
    				}
    			}
    		}
    	}
    }
    
    //构建二叉树
    public void buildTree(int[] data){
    	for(int i=0;i<data.length;i++){
    		insert(data[i]);
    	}
    }
    
    //前序遍历
    public void preOrder(Node localroot){
    	if(localroot!=null){
    		System.out.print(localroot.data+" ");
    		preOrder(localroot.left);
    		preOrder(localroot.right);
    	}
    }
    public void preOrder(){
    	this.preOrder(this.root);
    }
    
    //中序遍历
    public void inOrder(Node localroot){
    	if(localroot!=null){
    		inOrder(localroot.left);
    		System.out.print(localroot.data+" ");
    		inOrder(localroot.right);
    	}
    }
    public void inOrder(){
    	this.inOrder(this.root);
    }
    
    //后序遍历
    public void postOrder(Node localroot){
    	if(localroot!=null){
    		postOrder(localroot.left);
    		postOrder(localroot.right);
    		System.out.print(localroot.data+" ");
    	}
    }
    public void postOrder(){
    	this.postOrder(this.root);
    }
    
	public static void main(String[] args) {
		BinaryTree bitree=new BinaryTree();
		int[] data={2,8,7,4,9,3,1,6,7,5};
		bitree.buildTree(data);
		System.out.print("二叉排序树的前序遍历：");
		bitree.preOrder();
		System.out.println();
		System.out.print("二叉排序树的中序遍历：");
        bitree.inOrder();
        System.out.println();
        System.out.print("二叉排序树的后序遍历：");
        bitree.postOrder();
        System.out.println();
	}

}
