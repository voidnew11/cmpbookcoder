package cmpbookcoder.datastruct;
/*如何用O(1)时间复杂度求栈中最小元素？
 *采用空间换时间的方法降低时间复杂度，思路为：
 *使用两个栈结构，一个栈用来存储数据，另一个栈用来存储栈的最小元素；
 *如果当前入栈的元素比原来栈中的最小值还小，则把这个值压入保存最小元素的栈中；
 *在出栈时，如果当前出栈的元素恰好为当前栈的最小值，保存最小值的栈顶元素也出栈，使得当前的最小值变为其入栈之前的那个最小值*/
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
