//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    vector<vector<int>> insertInterval(vector<vector<int>> &intervals,
                                       vector<int> &newInterval) {
        // code here
        vector<vector<int>> ans;
        bool merged=false;
        int start=newInterval[0],end=newInterval[1];
        
        for(auto x:intervals){
            if(x[1]<newInterval[0]){
                ans.push_back(x);
            }
            else if(x[0]>newInterval[1]){
                if(!merged){
                    ans.push_back({start,end});
                    merged=true;
                }
                ans.push_back(x);
            }
            else{
                start=min(start,x[0]);
                end=max(end,x[1]);
            }
        }
        
        if(!merged)
        ans.push_back({start,end});
        
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        vector<vector<int>> intervals(N, vector<int>(2));
        for (int i = 0; i < N; i++) {
            cin >> intervals[i][0] >> intervals[i][1];
        }
        vector<int> newInterval(2);
        cin >> newInterval[0] >> newInterval[1];

        Solution obj;
        vector<vector<int>> ans = obj.insertInterval(intervals, newInterval);
        cout << "[";
        for (int i = 0; i < ans.size(); i++) {
            cout << "[" << ans[i][0] << ',' << ans[i][1] << ']';
            if (i != (ans.size() - 1))
                cout << ",";
        }
        cout << "]" << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends