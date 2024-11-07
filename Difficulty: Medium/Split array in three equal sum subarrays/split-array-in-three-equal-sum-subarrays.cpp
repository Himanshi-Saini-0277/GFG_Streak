//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
//  Class Solution to contain the method for solving the problem.
class Solution {
  public:
    // Function to determine if array arr can be split into three equal sum sets.
    vector<int> findSplit(vector<int>& arr) {
        // code here
        int n = arr.size();
        vector<int>pf(n+1,0);
        vector<int>suff(n+1, 0);
        pf[0] = arr[0];
        suff[n-1] = arr[n-1];
        for(int i=1;i<n;i++){
            pf[i] = pf[i-1]+arr[i];
        }
        for(int i=n-2;i>=0;i--){
            suff[i] = suff[i+1] + arr[i];
        }
        
        int i=0,j=n-1;
        while(i<j){
            if(pf[i]>suff[j]){
                j--;
            } else if(pf[i]<suff[j]){
                i++;
            } else{
                if(pf[i] == suff[j]){
                    j--;
                 if(j>=i and pf[j] == 2*pf[i]){
                   return {i,j};
                }
                }else {
                    return {-1, -1};
                }
            }
        }
        return {-1,-1};
    }
};

//{ Driver Code Starts.

int main() {
    int test_cases;
    cin >> test_cases;
    cin.ignore();
    while (test_cases--) {
        string input;
        vector<int> arr;

        // Read the array from input line
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        // Solution instance to invoke the function
        Solution ob;
        vector<int> result = ob.findSplit(arr);

        // Output result
        if (result[0] == -1 && result[1] == -1 || result.size() != 2) {
            cout << "false" << endl;
        } else {
            int sum1 = 0, sum2 = 0, sum3 = 0;
            for (int i = 0; i < arr.size(); i++) {
                if (i <= result[0])
                    sum1 += arr[i];

                else if (i <= result[1])
                    sum2 += arr[i];

                else
                    sum3 += arr[i];
            }
            if (sum1 == sum2 && sum2 == sum3) {
                cout << "true" << endl;
            } else {
                cout << "false" << endl;
            }
        }
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends