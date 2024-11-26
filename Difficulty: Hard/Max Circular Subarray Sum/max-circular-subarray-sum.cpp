//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
class Solution {
  public:
    // arr: input array
    // Function to find maximum circular subarray sum.
    int circularSubarraySum(vector<int> &arr) {
        // your code here
        int s=0;
        int sum=0;
        int res=0;
        for(auto it:arr)
        {
            sum+=it;
            s+=it;
            if(s<0)
            s=0;
            
            res=max(res,s);
        }
        s=0;
        int x=INT_MAX;
        for(auto it:arr)
        {
            s+=it;
            if(s>0)
            s=0;
            
            x=min(x,s);
        }
        res=max(res,sum-x);
        return res;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;

        // Read first array
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        int res = ob.circularSubarraySum(arr);

        cout << res << endl;
    }
    return 0;
}

// } Driver Code Ends