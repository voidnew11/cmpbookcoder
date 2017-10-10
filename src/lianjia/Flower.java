package lianjia;
/*n朵花，魅力值bi，想要两朵魅力值相差最大的化，求有多少种方案？
 * 输入：
 * 5
 * 3 1 2 3 1
 * 输出：最大差异值  方案数
 * 2 4*/
public class Flower {
	/*#include <iostream>
	#include <vector>
	#include <algorithm>
	#include <unordered_map>
	using namespace std;
	int main()
	{
	    int n;
	    while (cin>>n) {
	        vector<long> data;
	        for (long i = 0;i<n;i++){
	            long t;
	            cin>>t;
	            data.push_back(t);
	        }
	        
	        sort(data.begin(),data.end());
	        unordered_map<long,long> m;
	        for (auto x : data){
	            m[x]++;
	        }
	        long lmax;
	        lmax = *(data.end()-1) - *(data.begin());
	        if (lmax == 0) {
	            cout << lmax << " " << n*(n-1) / 2 << endl;
	            continue;
	        }
	        long count =0;
	        for(auto x : data){
	            if (m.find(x+lmax)!=m.end())
	            {
	                count+=m[x+lmax];
	            }
	        }
	        cout << lmax << " " << count << endl;
	        
	        
	    }
	}*/
}
