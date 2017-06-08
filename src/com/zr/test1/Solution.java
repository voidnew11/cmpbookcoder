package com.zr.test1;

import java.util.Scanner;

public class Solution  
{  
    public static int thirdMin(int[] nums)  
    {  
        long first, second, third;  
        first = second = third = Integer.MAX_VALUE;  
        for (int num : nums)  
        {  
            if (num == first || num == second || num == third) continue;  
            if (num < first)  
            {  
                third = second;  
                second = first;  
                first = num;  
            }  
            else if (num < second)  
            {  
                third = second;  
                second = num;  
            }  
            else if (num < third) third = num;  
        }  
  
        return (third == Integer.MAX_VALUE) ? -1 : (int)third;  
    }  
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] price = new int[n];
        for(int i = 0; i < n; i++){
            price[i] = sc.nextInt();
        } 
        System.out.println(thirdMin(price));

    }
}  
