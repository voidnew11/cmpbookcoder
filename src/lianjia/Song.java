package lianjia;
import java.util.*;
import java.io.*;
/*С��ϲ���ڻ����е�ʱ�����ֻ������֣�����N�׸����ֻ����������;�У���������P�׸裬�����������һ�����ű����P�׸�����������ű�Ĺ����ǣ� 
��(1)ÿ�׸趼Ҫ���ٱ�����һ�� 
(2)������һ���ĸ��м䣬������M�������ĸ� 
С�������ж����ֲ�ͬ�Ĳ��ű���Բ�������ô����N,M,P��������һ�£�������ȡ1000000007������
���룺 
��������N,M,P 
����N��Χ��1��100 
����M��Χ��0��N 
����P��Χ��N��100
��� ��
��������mod 1000000007������ 
�������� 
1 0 3 
������� 
1 
��ʾ 
��������
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
