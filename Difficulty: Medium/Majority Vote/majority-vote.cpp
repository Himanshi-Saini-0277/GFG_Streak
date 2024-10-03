//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    // Function to find the majority elements in the array
    vector<int> findMajority(vector<int>& nums) {
        // Your code goes here.
        int n = nums.size();
        
        int cnt1 = 0, ele1 = -1, cnt2 = 0, ele2 = -1;
        
        for(int x : nums) {
            if(cnt1 == 0 && ele2 != x) {
                cnt1 = 1; ele1 = x;
            }
            else if(cnt2 == 0 && ele1 != x) {
                cnt2 = 1; ele2 = x;
            }
            else if(ele1 == x) ++cnt1;
            else if(ele2 == x) ++cnt2;
            else {
                --cnt1; 
                --cnt2;
            }
        }
        
        cnt1 = cnt2 = 0;
        for(int x : nums) {
            if(ele1 == x) ++cnt1;
            if(ele2 == x) ++cnt2;
        }
        
        vector<int> ans;
        if(cnt1 > n / 3) ans.push_back(ele1);
        if(cnt2 > n / 3) ans.push_back(ele2);
        
        if(ans.empty()) ans.push_back(-1);
        
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {

        string s;
        getline(cin, s);
        stringstream ss(s);
        vector<int> nums;
        int num;
        while (ss >> num) {
            nums.push_back(num);
        }
        Solution ob;
        vector<int> ans = ob.findMajority(nums);
        for (auto &i : ans)
            cout << i << " ";
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends