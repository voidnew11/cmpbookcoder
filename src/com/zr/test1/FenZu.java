package com.zr.test1;
import java.util.*;
/*团队建设-求连通分量
 * #include <iostream>
#include <string>
using namespace std;
int f[123456];
int find(int x) {
    return x == f[x] ? f[x] : f[x] = find(f[x]);
}
void un(int x, int y) {
    x=find(x);y=find(y);
    if(x!=y)
        f[x]=y;
}

int main()
{

    int n,m;
    cin>>n;
    for(int i=1;i<=n;i++) f[i]=i;
    for(int i=1;i<=n;i++) {
        cin>>m;
        un(i,m);
    }
    int ans = 0;
    for(int i=1;i<=n;i++) {
        if(i==f[i])
            ans++;
    }
    cout<< ans<<endl;
}*/
public class FenZu {
	public static int [] p = new int[12345];
	public static int find(int x){
		int tmp=0;
		if(x == p[x])
			tmp = p[x];
		while(x != p[x]){
			p[x] = find(p[x]);
			if(x == p[x]){
				tmp = p[x];
				break;
			}
		}
		return tmp;
	}
    public static void un(int x, int y){
	x=find(x);
	y=find(y);
	if(x!=y){
		p[x] = y;
	}
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m;
        int res=0;
        for(int i = 1; i <= n; i++){
        	p[i] = i;
        }
        for(int i =1; i<= n; i++){
        	m = sc.nextInt();
        	un(i,m);
        }
       for(int i = 1; i <= n; i++){
    	   if(i == p[i])
    		   res+=1;
       }
       System.out.println(res);
	}

}
