/*��ӡ����Բ��������ͬ�İ뾶��Բ�Ĵ�С��֮�ı�
 * ˼·��y-�����꣬x-�����ֱ꣬�������Σ�Բ�ģ�r,r��,r*r=(y-r)*(y-r)+(r-x)*(r-x)
 * x=r-sqrt(r*r-(y-r)*(y-r))=r-sqrt(2*y*r-y*y)*/
package crazyjava.ch03;
import java.lang.Math;
public class PrintCircle {
	//��һ
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
        int r=10;//����Բ�뾶
        //������y,���ֵΪ2r,y+2��������
        for(int y=0;y<=2*r;y=y+2) {
        	//������
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
   //����
	//��ͼ����������Բ�뾶�����Բ
	public static void paint(int r) {
		//�ٶ�Բ���ڣ�r,r����
		int x=0;//x�����꿪ʼ��
		int y=2*r;//y�����꿪ʼ��
		int c=0;//�м�Ŀո�����
		int z=2;//ÿ�еݼ�����������Ϊ2��Ϊ�˵�����Ļ�ݺ��
		
		for(int i=2*r;i>=0;i=i-z) {
			//��ȡ��*���x����
			x=getX(r,y);
			//�Ȼ���yֵ����ߵ�*
			System.out.print(getSpace(x)+"*");
			c=2*(r-x);//��Բ�Ķ�Ӧ����ո�
			//�ٻ���yֵ�ұߵ�*
			System.out.println(getSpace(c)+"*");
			//ÿ��yֵ�ݼ�
			y-=z;
		}
	}
	public static int getX(int r,int y) {
		//ȥֱ�������γ��߳�
		int h=y-r;
		//��ֱ�������ζ̱߳�
		double l=Math.sqrt((r*r)-(h*h));
		//ȡxֵ��Math.round()������ӽ�������
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
