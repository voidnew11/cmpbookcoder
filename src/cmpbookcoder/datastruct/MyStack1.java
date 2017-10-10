package cmpbookcoder.datastruct;
/*�����O(1)ʱ�临�Ӷ���ջ����СԪ�أ�
 *���ÿռ任ʱ��ķ�������ʱ�临�Ӷȣ�˼·Ϊ��
 *ʹ������ջ�ṹ��һ��ջ�����洢���ݣ���һ��ջ�����洢ջ����СԪ�أ�
 *�����ǰ��ջ��Ԫ�ر�ԭ��ջ�е���Сֵ��С��������ֵѹ�뱣����СԪ�ص�ջ�У�
 *�ڳ�ջʱ�������ǰ��ջ��Ԫ��ǡ��Ϊ��ǰջ����Сֵ��������Сֵ��ջ��Ԫ��Ҳ��ջ��ʹ�õ�ǰ����Сֵ��Ϊ����ջ֮ǰ���Ǹ���Сֵ*/
public class MyStack1 {
 MyStack<Integer> elem;
 MyStack<Integer> min;
 public MyStack1(){
	elem=new MyStack<Integer>();
	min=new MyStack<Integer>();
  }
  
  public void push(int data){
	  elem.push(data);
	  if(min.isEmpty()){
		  min.push(data);
	  }else{
		  if(data<min.peek())
			  min.push(data);
	  }
  }
  
  public int pop(){
	  int topdata=elem.peek();
	  elem.pop();
	  if(topdata==this.min())
		  min.pop();
	  return topdata;
  }
  
  public int min(){
	  if(min.isEmpty()){
		  return Integer.MAX_VALUE;
	  }else{
		  return min.peek();
	  }
  }
}
