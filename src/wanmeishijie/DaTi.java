package wanmeishijie;

import java.util.Scanner;

public class DaTi {

	public static int solution(int m, int[] A, int V[]) {
        // write your code here
        int[][] dp = new int[A.length + 1][m + 1];
        for(int i = 0; i <= A.length; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(A[i-1] > j){
                    dp[i][j] = dp[(i-1)][j];
                }
                else{
                    dp[i][j] = Math.max(dp[(i-1)][j], dp[(i-1)][j-A[i-1]] + V[i-1]);
                }
            }
        }
        return dp[A.length][m];
    }

public static void main(String[] args) {
	// TODO Auto-generated method stub
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] f = new int[n];
    int[] t = new int[n];
    for(int i = 0; i < n; i++){
    	f[i] = in.nextInt();
    }
    for(int i = 0; i < n; i++){
    	t[i] = in.nextInt();
    }
    int m = in.nextInt();    
    System.out.println(solution(m,f,t));
  }
}
