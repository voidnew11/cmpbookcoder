package sogou;
import java.util.*;
import java.io.*;
public class DunJiao {
	public static int helper(int n,double[] ele) {
		  if(n <= 2)
			  return 0;
		  int count = 0;
		  for(int i = 0; i < n-2; i++) {
			  int j = i+2;
			  for(;j < n;j++) {
				  if(ele[j] - ele[i] < 180) {
					  count++;
				  }else{
					  break;
				  }
			  }
		  }
		  return count;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[] ele = new double[n];
        for(int i = 0; i < n; i++){
        	ele[i] = in.nextDouble();
        }
        int ans = helper(n, ele);
        System.out.println(ans);
	}

}
