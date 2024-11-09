//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class Solution {
  public:
    string minSum(vector<int> &arr) {
        // code here
         if(arr.size() == 2) {
            return to_string(arr[0] + arr[1]);
        }

        sort(arr.begin(), arr.end());
        string sum1 = "", sum2 = "";
        
        for (int i = 0; i < arr.size(); i += 2) {
            sum1 += to_string(arr[i]);
        }

        for (int i = 1; i < arr.size(); i += 2) {
            sum2 += to_string(arr[i]);
        }

        int carry = 0;
        string result;
        int i = sum1.size() - 1;
        int j = sum2.size() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? sum1[i] - '0' : 0;
            int digit2 = (j >= 0) ? sum2[j] - '0' : 0;
            
            int total = digit1 + digit2 + carry;
            result += to_string(total % 10);
            
            carry = total / 10;
            
            i--;
            j--;
        }
        
        reverse(result.begin(), result.end());

        int startIndex = 0;
        while (startIndex < result.size() && result[startIndex] == '0') {
            startIndex++;
        }
        
        if (startIndex == result.size()) {
            return "0";
        }

        return result.substr(startIndex);
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> a;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            a.push_back(number);
        }

        Solution ob;
        string ans = ob.minSum(a);
        cout << ans << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends