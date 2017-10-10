package com.zr.test1;
import java.util.*;
/*搜狐-公司员工数：1 1 1 2 3 4 6 9*/
public class Test6 {		
	public static int helper(int a) {
		int[] res = new int[a+1];
		if(a <= 3)
			return 1;
		res[1] = 1;
		res[2] = 1;
		res[3] = 1;
		int i = 4;
		while(i <= a) {
			res[i] = res[i-1] + res[i - 3];
			i++;
		}
		return res[a];
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		
		System.out.println(helper(n));
	}
}
