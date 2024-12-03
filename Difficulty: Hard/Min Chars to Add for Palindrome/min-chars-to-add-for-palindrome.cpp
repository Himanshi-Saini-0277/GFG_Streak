//{ Driver Code Starts
/* Driver program to test above function */

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int minChar(string& s) {
        // Write your code here
        string rev=s;
        int n=s.size();
        if(n==0) return 0;
        
        reverse(rev.begin(),rev.end());
        string w= s + "*" + rev;
       
        int i=1;
        int length=0;
        vector<int>LPS(w.size());
        LPS[0]=0;
        
        while(i < w.size())
        {
            if(w[i]==w[length])
            {
                length++;
                LPS[i]=length;
                i++;
            }
            
            else{
                
                if(length!=0)
                {
                    length=LPS[length-1];
                }
                else{
                    LPS[i]=0;
                    i++;
                }
                
            }
        }
        
        return n-LPS[w.size()-1];
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string str;
        cin >> str;
        Solution ob;
        int ans = ob.minChar(str);
        cout << ans << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}

// } Driver Code Ends