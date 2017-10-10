package com.zr.test1;
import java.util.*;
import java.math.*;
public class FindPow {
	public static BigDecimal helper(double a, int b) {
		BigDecimal  bd = new BigDecimal(a+"");
	    BigDecimal aa = bd.pow(b);
	    return aa;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
     
         double R;
         int n;
         List<BigDecimal> list = new ArrayList();
        // while (sc.hasNext()) {
            R = sc.nextDouble();
            n = sc.nextInt();
            BigDecimal result;  
 	       result = helper(R,n);
 	       list.add(result);
         //}
         for(BigDecimal num : list) {
         	System.out.println(num);
         }  
       
         
	}

}
