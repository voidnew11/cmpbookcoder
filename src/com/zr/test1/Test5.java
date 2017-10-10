package com.zr.test1;
/*找第二大的数*/
public class Test5 {
	/*#include <iostream>
	#include <vector>
	# include <set>
	using namespace std;
	int find_second_biggest(vector<int> &v){
	    
	        int len = v.size();
	        int max,second;
	        if (len < 2){
	                return -1; 
	        }
	        if (v[0]>v[1]){ 
	                second = v[1];
	                max = v[0];
	        }
	        else{
	                second = v[0];
	                max = v[1];
	        }
	        for (int i=2; i< len; i++){
	                if(max < v[i]){
	                        second = max;
	                        max = v[i];
	                }else if(max == v[i]){
	                	max = v[i];
	                }
	                else if (second < v[i]){
	                        second = v[i];
	                }
	        }
	        return second;
	}
	int main(){
	    int n;
	    cin>>n;
	    vector <int> data ;
	    set<int> iset;
	    for(int i = 0; i < n; i++){
	        int t;
	        cin>>t;
	       if (iset.find(t)==iset.end()){ 
	           data.push_back(t);
	           iset.insert(t);
	       }
	    }
	    if(data.size() < 2){
	        cout<< -1;
	        return 0;
	    }
	    cout<<find_second_biggest(data)<<endl;
	}*/
}
