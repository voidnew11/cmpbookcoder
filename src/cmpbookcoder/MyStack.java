package cmpbookcoder;
/*用数组实现栈*/
import java.util.Arrays;
public class MyStack<E> {
    private Object[] stack;
    private int size;//数组中存储元素的个数
    public MyStack(){
    	stack=new Object[10];//初始长度为10
    }
    //判断堆栈是否为空
    public boolean isEmpty(){
    	return size==0;
    }
    //栈顶元素
    public E peek(){
    	if(isEmpty()){
    		return null;
    	}
    	return (E)stack[size-1];
    }
    //找到栈顶元素并弹出
    public E pop(){
    	E e=peek();
    	stack[size-1]=null;
    	size--;
    	return e;
    }
    //入栈
    public E push(E item){
    	ensureCapacity(size+1);//检查容量
    	stack[size++]=item;
    	return item;
    }
    //判断数组容器是否已满，若已满，则扩充数组空间
    public void ensureCapacity(int size){
    	int len=stack.length;
    	if(size>len){//数组已满
    		int newlen=10;//每次扩充的容量
    		stack=Arrays.copyOf(stack, newlen);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyStack<Integer> s=new MyStack<Integer>();
        s.push(1);
        s.push(2);
        System.out.println("栈中的元素个数："+s.size);
        System.out.println("栈顶的元素为："+s.pop());
        System.out.println("栈顶的元素为："+s.pop());
        System.out.println("栈中的元素个数："+s.size);
	}

}
