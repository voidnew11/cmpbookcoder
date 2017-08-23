/*打印近似圆，给定不同的半径，圆的大小随之改变
 * 思路：y-纵坐标，x-横坐标，直角三角形，圆心（r,r）,r*r=(y-r)*(y-r)+(r-x)*(r-x)
 * x=r-sqrt(r*r-(y-r)*(y-r))=r-sqrt(2*y*r-y*y)*/
package crazyjava.ch03;
import java.lang.Math;
public class PrintCircle {
	//法一
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
        int r=10;//定义圆半径
        //纵坐标y,最大值为2r,y+2调整胖瘦
        for(int y=0;y<=2*r;y=y+2) {
        	//横坐标
        	long x=Math.round(r-Math.sqrt(2*y*r-y*y));
        	for(int i=0;i<=2*r;i++) {
        		if(i==x||i==2*r-x)
        			System.out.print("*");
        		else 
        			System.out.print(" ");
        	}
        	System.out.print("\n");
        	
        }
	}*/
   //法二
	//画图函数，输入圆半径，输出圆
	public static void paint(int r) {
		//假定圆心在（r,r）处
		int x=0;//x的坐标开始处
		int y=2*r;//y的坐标开始处
		int c=0;//中间的空格数量
		int z=2;//每行递减量，步长设为2是为了调节屏幕纵横比
		
		for(int i=2*r;i>=0;i=i-z) {
			//获取画*点的x坐标
			x=getX(r,y);
			//先画该y值上左边的*
			System.out.print(getSpace(x)+"*");
			c=2*(r-x);//以圆心对应输出空格
			//再画该y值右边的*
			System.out.println(getSpace(c)+"*");
			//每次y值递减
			y-=z;
		}
	}
	public static int getX(int r,int y) {
		//去直角三角形长边长
		int h=y-r;
		//求直角三角形短边长
		double l=Math.sqrt((r*r)-(h*h));
		//取x值，Math.round()返回最接近的整数
		return (int)Math.round(r-l);
	}
	public static String getSpace(int i) {
		String s="";
		for(int j=0;j<i;j++) {
			s+=" ";
		}
		return s;
	}
	public static void main(String[] args) {
		paint(10);
	}
}
