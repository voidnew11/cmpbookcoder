package com.zr.test1;
import java.util.*;
public class FindNum {
	     public static boolean strStr(String source, String target) {
	        if (source == null || target == null){
	            return false;
	        }
	        
	        int i, j;
	        for (i = 0; i < source.length() - target.length() + 1; i++){
	            for (j = 0; j < target.length(); j++){
	                if (source.charAt(i+j) != target.charAt(j)){
	                    break;
	                }
	            }
	            if (j == target.length()){
	                return true;
	            }
	        }
	        
	        return false;
	    }
	    public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	        Queue<String> q = new LinkedList<String>();
	        while(sc.hasNext()){
	        	q.offer(sc.nextLine());
	        }
	        int ans = 0;
	        for(String tmp : q){
	        	String str = tmp;
	        	String s [] =str.split("u51");
			    ans+=s.length;
	        }
	        System.out.println(ans);
	        
	    }
}
