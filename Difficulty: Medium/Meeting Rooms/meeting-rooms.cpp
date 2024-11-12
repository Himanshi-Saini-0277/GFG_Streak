//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    bool static comp(vector<int> a,vector<int> b){
        return a[1] < b[1];
    }
    bool canAttend(vector<vector<int>> &arr) {
        // Your Code Here
        sort(arr.begin(),arr.end(),comp);
        for(int i=1;i<arr.size();i++){
            int nextStart = arr[i][0];
            int prevEnd = arr[i-1][1];
            if(prevEnd > nextStart){
                return false;
            }
        }
        return true;
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n;
        cin >> n;
        vector<vector<int>> arr(n);
        for (int i = 0; i < n; i++) {
            int x, y;
            cin >> x >> y;
            arr[i].push_back(x);
            arr[i].push_back(y);
        }
        cin.ignore();
        Solution obj;
        bool ans = obj.canAttend(arr);
        if (ans)
            cout << "true" << endl;
        else
            cout << "false" << endl;
    }
    return 0;
}
// } Driver Code Ends