package lianjia;
import java.util.*;
import java.io.*;
/*小明喜欢在火车旅行的时候用手机听音乐，他有N首歌在手机里，在整个火车途中，他可以听P首歌，所以他想产生一个播放表产生P首歌曲，这个播放表的规则是： 
　(1)每首歌都要至少被播放一次 
(2)在两首一样的歌中间，至少有M首其他的歌 
小明在想有多少种不同的播放表可以产生，那么给你N,M,P，你来算一下，输出结果取1000000007的余数
输入： 
　　输入N,M,P 
　　N范围在1到100 
　　M范围在0到N 
　　P范围在N到100
输出 ：
　输出结果mod 1000000007的余数 
样例输入 
1 0 3 
样例输出 
1 
提示 
其他样例
1 1 3
0

2 0 3
6

50 5 100
222288991*/
public class Song {
	
	/*#include<cstdio>
	#include<cstring>
	#include<iostream>
	#include<cmath>
	#include<algorithm>
	#define ll long long
	#define mo 1000000007
	using namespace std;
	ll dp[105][105];
	int n,m,p;
	ll dfs(int i,int j)
	{
	    if (dp[i][j]!=-1) return dp[i][j];
	    if (i==p)
	    {
	        if (j==n){dp[i][j]=1;return 1;}
	        else{dp[i][j]=0;return 0;}  
	    }
	    dp[i][j]=0;
	    if (j>m)dp[i][j]=dfs(i+1,j)*(j-m);
	    if (j<n)dp[i][j]+=dfs(i+1,j+1)*(n-j);
	    if (dp[i][j]>=mo) dp[i][j]%=mo;
	    return dp[i][j];
	}
	int main()
	{
	    scanf("%d%d%d",&n,&m,&p);
	    for (int i=0;i<=p;i++)
	        for (int j=0;j<=n;j++)
	            dp[i][j]=-1;
	    printf("%lld",dfs(0,0));
	    return 0;
	}*/
}
