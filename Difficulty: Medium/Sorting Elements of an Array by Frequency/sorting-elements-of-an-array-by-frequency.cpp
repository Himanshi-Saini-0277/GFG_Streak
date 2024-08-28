//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    // Complete this function
    // Function to sort the array according to frequency of elements.
    vector<int> sortByFreq(vector<int>& arr) {
        // Your code here
        vector<int> ans;
        int n=arr.size();
        map<int,int> mp;
        multiset<pair<int,int>> m;
        for(int i=0;i<n;i++){
            mp[arr[i]]++;
        }
        for(auto it:mp){
              int num=it.first;
           int freq=it.second;
           m.insert({freq,-num});
        }
        for(auto it:m){
            int freq=it.first;
            int num=it.second;
            while(freq>0){
                ans.push_back(-num);
                freq--;
            }
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};

//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    cin.ignore();
    while (t--) {

        string input;
        int num;
        vector<int> arr;

        getline(cin, input);
        stringstream s2(input);
        while (s2 >> num) {
            arr.push_back(num);
        }
        Solution obj;
        vector<int> v;
        v = obj.sortByFreq(arr);
        for (int i : v)
            cout << i << " ";
        cout << endl;
    }

    return 0;
}

// } Driver Code Ends