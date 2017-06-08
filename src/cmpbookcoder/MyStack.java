package cmpbookcoder;
/*������ʵ��ջ*/
import java.util.Arrays;
public class MyStack<E> {
    private Object[] stack;
    private int size;//�����д洢Ԫ�صĸ���
    public MyStack(){
    	stack=new Object[10];//��ʼ����Ϊ10
    }
    //�ж϶�ջ�Ƿ�Ϊ��
    public boolean isEmpty(){
    	return size==0;
    }
    //ջ��Ԫ��
    public E peek(){
    	if(isEmpty()){
    		return null;
    	}
    	return (E)stack[size-1];
    }
    //�ҵ�ջ��Ԫ�ز�����
    public E pop(){
    	E e=peek();
    	stack[size-1]=null;
    	size--;
    	return e;
    }
    //��ջ
    public E push(E item){
    	ensureCapacity(size+1);//�������
    	stack[size++]=item;
    	return item;
    }
    //�ж����������Ƿ�������������������������ռ�
    public void ensureCapacity(int size){
    	int len=stack.length;
    	if(size>len){//��������
    		int newlen=10;//ÿ�����������
    		stack=Arrays.copyOf(stack, newlen);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyStack<Integer> s=new MyStack<Integer>();
        s.push(1);
        s.push(2);
        System.out.println("ջ�е�Ԫ�ظ�����"+s.size);
        System.out.println("ջ����Ԫ��Ϊ��"+s.pop());
        System.out.println("ջ����Ԫ��Ϊ��"+s.pop());
        System.out.println("ջ�е�Ԫ�ظ�����"+s.size);
	}

}
