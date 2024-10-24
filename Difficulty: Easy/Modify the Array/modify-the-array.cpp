//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    vector<int> modifyAndRearrangeArray(vector<int> &arr) {
        // Complete the function
        int n = arr.size();
        vector<int>ans(n);
        int i = 0,j = n-1;
        for(int k = 0;k<n;k++) {
            if(k+1<n && arr[k]!=0 && arr[k+1]!=0 && arr[k] == arr[k+1]) {
                ans[i++] = 2*arr[k];
                arr[k+1] = 0;
            }
            else if(arr[k]!=0) {
                ans[i++] = arr[k];
            }
            else ans[j--] = arr[k];
        }
        return ans;
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
        vector<int> ans = obj.modifyAndRearrangeArray(arr);
        for (int i = 0; i < ans.size(); i++) {
            cout << ans[i] << " ";
        }
        cout << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends