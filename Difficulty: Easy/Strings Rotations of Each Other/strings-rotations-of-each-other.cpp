//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    vector<int> lps( string &p ){
        int n = p.size(); vector<int> lps(n+1, 0);
        for ( int i = 1; i<n; i++ ){
            int j = lps[i-1];
            while ( j > 0 && p[i] != p[j] ) j = lps[j-1];
            if ( p[i] == p[j] ) j++;
            lps[i] = j;
        } return lps;
    }
    bool areRotations(string &s1, string &s2) {
        s2 += s2; vector<int> lpsA = lps(s1);
        int n = s2.size(), m = s1.size();
        int i = 0, j = 0; 
        while ( i < n ){
            if ( s2[i] == s1[j] ) i++, j++;
            if ( j == m ) return true;
            else if ( i < n && s2[i] != s1[j] ){
                if ( j ) j = lpsA[j-1];
                else i++;
            }
        } return false;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string s1;
        string s2;
        cin >> s1 >> s2;
        Solution sol;
        int result = sol.areRotations(s1, s2);
        if (result) {
            cout << "true" << endl;

        } else {
            cout << "false" << endl;
        }
        cout << "~"
             << "\n";
    }
    return 0;
}

// } Driver Code Ends