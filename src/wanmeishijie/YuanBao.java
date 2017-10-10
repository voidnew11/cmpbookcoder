package wanmeishijie;
import java.util.*;
public class YuanBao {
	public static int solution(int[] a, int[] b){
		int ans=0;
		int n = a.length;
		Arrays.sort(a);
		Arrays.sort(b);		
		int beat = 0, eq = 0;
		int[] vis = new int[n];
		for(int i = 0; i < n; i++){
			vis[i] = 0;
		}
		for(int i = n-1; i >= 0; i--){
			for(int j = n-1; j >= 0; j--){
				if(b[j] <= a[i] && vis[j] == 0){
					vis[j] = 1;
					if(b[j] < a[i])
						beat++;
					else if(b[j] == a[i])
						eq++;
				}
			}
		}
		ans = beat*100-((n-beat-eq)*100);
		return ans;
	}
	 public static void main(String[] args){
		 Scanner in = new Scanner(System.in);
		 int n = in.nextInt();
		 int[] a = new int[n];
		 int[] b = new int[n];
		 for(int i = 0; i < n; i++){
			 a[i] = in.nextInt(); 
		 }
		 for(int i = 0; i < n; i++){
			 b[i] = in.nextInt();
		 }
		 System.out.println(solution(a,b));
	 }

}
