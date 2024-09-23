//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
class Solution {
  public:
    vector<int> findTwoElement(vector<int>& arr) {
        // code here
        int n = arr.size();
        int mod = n + 1;
        for(int i = 0; i < n; i++){
            int val = arr[i] % mod;
            arr[val - 1] += mod;
        }
        vector<int> ans (2, 0);
        for(int i = 0; i < n; i++){
            if(arr[i]/mod == 2){
                ans[0] = i + 1;
            }
            if(arr[i]/mod == 0){
                ans[1] = i + 1;
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> a(n);
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        auto ans = ob.findTwoElement(a);
        cout << ans[0] << " " << ans[1] << "\n";
    }
    return 0;
}
// } Driver Code Ends