//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:
    int mod =1e9+7;
    int modpow(int n,int power){
        if(power == 0){
            return 1;
        }
        int val = modpow(n,power/2);
        return power%2 == 0? (val%mod*val%mod)%mod:( n*(val%mod*val%mod)%mod)%mod;
    }
    int countgroup(vector<int>& arr) {
        int n =arr.size();
        int xorr =0;
        for(int i =0;i< n;i++){
            xorr^=arr[i];
        }
        return xorr ==0? modpow(2,n-1) -1:0;
    }
};

//{ Driver Code Starts.
int main() {
    string ts;
    getline(cin, ts);
    int t = stoi(ts);
    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        Solution obj;
        int ans = obj.countgroup(arr);
        cout << ans << endl;
    }
}

// } Driver Code Ends