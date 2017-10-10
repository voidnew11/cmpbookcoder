package com.zr.test1;
import java.util.*;
public class FindDay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   int day=0;
	       int month=0;
	       int year=0;
	       int sum=0;
	       int leap;  
	       Scanner sc = new Scanner(System.in);
	       year=sc.nextInt();
	       month=sc.nextInt();
	       day=sc.nextInt();
	       switch(month)
	       {  
	       case 1:
	           sum=0;break;  
	       case 2:
	           sum=31;break;  
	       case 3:
	           sum=59;break;  
	        case 4:
	           sum=90;break;  
	       case 5:
	           sum=120;break;  
	       case 6:
	           sum=151;break;  
	       case 7:
	           sum=181;break;  
	       case 8:
	           sum=212;break;  
	       case 9:
	           sum=243;break;  
	       case 10:
	           sum=273;break;  
	       case 11:
	           sum=304;break;  
	       case 12:
	           sum=334;break;  
	       default:
	           System.out.println("data error");break;
	       }  
	       sum=sum+day; /*再加上某天的天数*/ 
	       if(year%400==0||(year%4==0&&year%100!=0))/*判断是不是闰年*/ 
	           leap=1;  
	       else 
	           leap=0;  
	       if(leap==1 && month>2)/*如果是闰年且月份大于2,总天数应该加一天*/ 
	           sum++;  
	       System.out.println(sum);
	       }
	}


