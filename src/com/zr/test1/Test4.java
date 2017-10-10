package com.zr.test1;
import java.util.Scanner;

public class Test4 {	  	
    	/**
    	 * Created by lsw on 14/09/2017.
    	 * √¿Õ≈-«Æ±“
    	 */
    	
    	    public static void main(String[] args) {
    	        Scanner sc = new Scanner(System.in);
    	        int n = sc.nextInt();
    	        int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100};
    	        int[][] dp = new int[7][n + 1];
    	        for(int i = 0; i < n + 1; i++) {
    	            dp[0][i] = i;
    	        }
    	        for(int i = 1; i < 7; i++) {
    	            dp[i][0] = 0;
    	            for(int j = 1; j < n + 1; j++) {
    	                if (j < coins[i]) {
    	                    dp[i][j] = 0;
    	                } else {
    	                    dp[i][j] = 1 + dp[i - 1][j - coins[i]];
    	                }
    	            }
    	        }
    	        for(int i = 6; i >= 0; i--) {
    	            if(dp[i][n] != 0) {
    	                System.out.print(i + 1 + " ");
    	                System.out.println(dp[i][n]);
    	                break;
    	            }
    	        }
    	    }    	
}
