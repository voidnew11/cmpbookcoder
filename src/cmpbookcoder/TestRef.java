package cmpbookcoder;
import java.util.Date;
class Obj implements Cloneable{
	private Date birth=new Date();
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth=birth;
	}
	public void changeDate() {
		this.birth.setMonth(4);
	}
	public Object clone() {
		Obj o=null;
		try {
			//«≥∏¥÷∆
			o=(Obj)super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		//…Ó∏¥÷∆
		o.birth=(Date)this.getBirth().clone();
		return o;
	}
}
public class TestRef { 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Obj a=new Obj();
       Obj b=(Obj)a.clone();
       b.changeDate();
       System.out.println("a="+a.getBirth());
       System.out.println("b="+b.getBirth());
	}

}
