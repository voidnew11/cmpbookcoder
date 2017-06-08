/**
 * 序列化的具体实例，实现Serializable接口
 */
package cmpbookcoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class People implements Serializable {
    private String name;
    private int age;
    public People(){
    	this.name="lili";
    	this.age=24;
    }
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        People p=new People();
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        try{
        	FileOutputStream fos=new FileOutputStream("perple.out");
        	oos=new ObjectOutputStream(fos);
        	oos.writeObject(p);
        	oos.close();
        }catch(Exception e){
        	
        }
        People p1;
        try{
        	FileInputStream fis=new FileInputStream("perple.out");
        	ois=new ObjectInputStream(fis);
        	p1=(People)ois.readObject();
        	System.out.println("name:"+p1.getName());
        	System.out.println("age:"+p1.getAge());
        	ois.close();
        }catch(Exception e){
        	
        }
	}

}
