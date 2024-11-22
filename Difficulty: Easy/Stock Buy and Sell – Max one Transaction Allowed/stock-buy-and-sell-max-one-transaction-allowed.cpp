//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int maximumProfit(vector<int> &prices) {
        // code here
        int n=prices.size();
        int ans=0;
        vector<int>v(n,0);
        for(int i=n-2;i>=0;i--){
            ans=max(ans,prices[i+1]);
            v[i]=ans;
        }
        ans=0;
        for(int i=0;i<n-1;i++){
            ans=max(ans,v[i]-prices[i]);
        }
        return ans;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> prices;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            prices.push_back(number);
        }

        Solution ob;
        int ans = ob.maximumProfit(prices);
        cout << ans << endl;
    }
    return 0;
}

// } Driver Code Ends