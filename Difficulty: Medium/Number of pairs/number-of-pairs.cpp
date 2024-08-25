//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    long long countPairs(vector<int> &arr, vector<int> &brr) {
        // Your Code goes here.
        long long ans = 0;
        sort(brr.begin(), brr.end());
        for (int x : arr) {
            if (x == 1) {
                continue;
            } else if (x == 2) {
                ans += upper_bound(brr.begin(), brr.end(), 1) - brr.begin();
                ans += brr.end() - lower_bound(brr.begin(), brr.end(), 5); 
            } else {
                ans += brr.end() - lower_bound(brr.begin(), brr.end(), x + 1);
                ans += upper_bound(brr.begin(), brr.end(), 1) - lower_bound(brr.begin(), brr.end(), 1); // y == 1
            }
            if (x == 3) {
                ans += upper_bound(brr.begin(), brr.end(), 2) - lower_bound(brr.begin(), brr.end(), 2);
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int T;
    cin >> T;
    cin.ignore();
    while (T--) {
        vector<int> ex;
        vector<int> a, b;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int num;
        while (ss >> num)
            ex.push_back(num);
        a = ex;
        getline(cin, input);
        ss.clear();
        ss.str(input);
        int num2;
        while (ss >> num2)
            b.push_back(num2);

        Solution ob;
        cout << ob.countPairs(a, b) << endl;
    }
}
// } Driver Code Ends