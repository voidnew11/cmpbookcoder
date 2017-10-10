package com.zr.test1;

public class BeautyNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*美丽数：n,十进制表示，没有重复数字，找出比n大的最小美丽数
		 * #include <iostream>
		#include <set>
		using namespace std;
		bool isB(int n) {
		    set<int> tmp;
		    while(n){
		        if (tmp.find(n%10) == tmp.end()){//相等，没找到
		            tmp.insert(n%10);
		        }else {
		            return false;
		        }
		        n = n/10;
		    }
		    return true;

		}
		int main()
		{
		    int n;
		    cin>>n;
		    int ans = -1;
		    for (int i=n+1;i<=9012;i++) {
		        if (isB(i)){ ans = i; break;}
		    }
		    cout << ans << endl;

		}
	}
*/
}
}
