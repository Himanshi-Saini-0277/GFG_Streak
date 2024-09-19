//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    // Function to reverse words in a given string.
    string reverseWords(string str) {
        // code here
         int n=str.length();
        string ans="";
        string v="";
        for(int i=n-1;i>=0;i--){
            
            
            if(str[i]!='.'){
                v+=str[i];
            }
            else{
                reverse(v.begin(),v.end());
                ans+=v;
               ans.push_back('.') ;
               v="";
            
                
            }
         
        }
        reverse(v.begin(),v.end());
      ans+=v;
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution obj;
        cout << obj.reverseWords(s) << endl;
    }
}
// } Driver Code Ends