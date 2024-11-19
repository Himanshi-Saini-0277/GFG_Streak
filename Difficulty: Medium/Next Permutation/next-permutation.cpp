//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    void nextPermutation(vector<int>& arr) {
        // code here
        int idx1 = arr.size() -1;
        int idx2 = idx1;
        int num = arr[idx1];
        while(idx1 > 0 && num <= arr[idx1])
        {
            num = arr[idx1];
            idx1--;
        }
        if(num > arr[idx1])
        {
            while(idx1 < idx2 & arr[idx1] >= arr[idx2])
            {
                idx2--;
            }
            swap(arr[idx1], arr[idx2]);
            idx1++;
            idx2 = arr.size() - 1;
        }
        while(idx1 < idx2)
        {
            swap(arr[idx1], arr[idx2]);
            idx1++;
            idx2--;
        }
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
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        Solution ob;
        int n = arr.size();
        ob.nextPermutation(arr);
        for (int i = 0; i < n; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends