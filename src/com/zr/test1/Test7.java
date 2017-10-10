package com.zr.test1;

import java.util.*;

public class Test7 {
	 public static String[] replaceSpace(String s1, String s2) {
		 HashSet<Character> set1 = new HashSet<Character>();
			HashSet<Character> set2 = new HashSet<Character>();
			String[] ans = new String[2];
			char [] ca = s1.toCharArray();
			char [] cb = s2.toCharArray();
			for(int i = 0; i < ca.length; i ++){
				set1.add(ca[i]);
			}
			for(int i = 0; i < cb.length; i ++){
				if(set1.contains(cb[i])){
					set2.add(cb[i]);
					cb[i]='_';
				}	
			}
			for(int i = 0; i < ca.length; i ++){
				if(set2.contains(ca[i])){
					ca[i]='_';
				}	
			}
			ans[0]=String.valueOf(ca);
			ans[1]=String.valueOf(cb);
			return ans;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String[] result = new String[2];
        String s1 = in.nextLine(); 
        String s2 = in.nextLine();
        result = replaceSpace(s1,s2);
        System.out.println(result[0]);
        System.out.println(result[1]);
        
        
	}

}
