/*round():��0.5����ȡ����ceil():����ȡ������Ϊ��������С������Ϊ��������С����floor():����ȡ������Ϊ��������С������Ϊ��������С��*/
package cmpbookcoder;
import java.lang.*;
public class MathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        float m=6.4f;
        float n=-6.4f;
        System.out.println("Math.round("+m+")="+Math.round(m));
        System.out.println("Math.round"+n+"=)"+Math.round(n));
        System.out.println("Math.ceil("+m+")="+Math.ceil(m));
        System.out.println("Math.ceil"+n+"=)"+Math.ceil(n));
        System.out.println("Math.floor("+m+")="+Math.floor(m));
        System.out.println("Math.floor"+n+"=)"+Math.floor(n));
	}

}
