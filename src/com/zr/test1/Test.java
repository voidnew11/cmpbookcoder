package com.zr.test1;
import java.util.*;
public class Test {	
	 static int n;           // 数字个数  
     static int a[];         // 所给数组  
     static int m;           // 结果数字个数  
     static int num[];       //当前数字  
     static int oper[];      //符号数组 0 1 2 3  + - * /  
     static int flag[];      //判断数字的使用  
     static int k;           //运算次数  
     static String s;        //计算式字符串            
    public static void main(String[] args) {  
            Scanner input = new Scanner(System.in);  
            n = input.nextInt();  
            m = input.nextInt();  
            num = new int[n];  
            oper = new int[n];  
            flag = new int[n];  
            a = new int[n];  
            for (int p = 0; p < n; p++) {  
                a[p] = input.nextInt();  
            }  
            input.close();  
            for (k = 0; k < n; k++) {  
                if (search(0)) {  
                    System.out.println(k);  
                    System.out.println(s);  
                    return;  
                }  
            }  
      
            System.out.println("No Solution! \n");  
      
        }  
      
        public static boolean found() {  
            int x = num[0];  
            for (int i = 0; i < k; i++) {  
                if (oper[i] == 0) {  
                    x += num[i + 1];  
                } else if (oper[i] == 1) {  
                    x -= num[i + 1];  
                } else if (oper[i] == 2) {  
                    x *= num[i + 1];  
                } else if (oper[i] == 3) {  
                    x /= num[i + 1];  
                }  
            }  
            return (x == m);  
        }  
      
        public static void getString(){  
            s = String.valueOf(num[0]);  
            for (int i = 0; i < k; i++) {  
                if (oper[i] == 0) {  
                    s +=("+"+String.valueOf(num[i+1]));  
                } else if (oper[i] == 1) {  
                    s +=("-"+String.valueOf(num[i+1]));  
                } else if (oper[i] == 2) {  
                    s +=("*"+String.valueOf(num[i+1]));  
                } else if (oper[i] == 3) {  
                    s +=("/"+String.valueOf(num[i+1]));  
                }  
            }  
        }  
        public static boolean search(int dep) {  
            if (dep > k) {  
                if (found()) {  
                    getString();  
                    System.out.println();  
                    return true;  
                } else {  
                    return false;  
                }  
      
            }  
            for (int i = 0; i < n; i++)  
                if (flag[i] == 0) {  
                    num[dep] = a[i];  
                    flag[i] = 1;  
                    for (int j = 0; j < 4; j++) {  
                        oper[dep] = j;  
                        if (search(dep + 1))  
                            return true;  
                    }  
                    flag[i] = 0;  
                }  
            return false;  
        }  
      
    }  
	

