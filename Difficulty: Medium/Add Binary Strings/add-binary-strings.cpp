//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:
    string addBinary(string& s1, string& s2) {
        // your code here
        reverse(s1.begin(),s1.end());
        reverse(s2.begin(),s2.end());
        int carry=0;
        string ans="";
        int len1=s1.length(),len2=s2.length();
        int i=0,j=0;
        while(i<len1 && j<len2){
            if((s1[i]=='1' && s2[j]=='1' && carry==0) ||
               (s1[i]=='1' && s2[j]=='0' && carry==1) || 
               (s1[i]=='0' && s2[j]=='1' && carry==1)
              ){
                carry=1;
                ans+='0';
            }
            else if(s1[i]=='1' && s2[j]=='1' && carry==1){
                carry=1;
                ans+='1';
            }
            else if((s1[i]=='1' && s2[j]=='0' && carry==0) ||
               (s1[i]=='0' && s2[j]=='1' && carry==0) || 
               (s1[i]=='0' && s2[j]=='0' && carry==1)
              ){
                carry=0;
                ans+='1';
            }
            else{
                carry=0;
                ans+='0';
            }
            i++;j++;
        }
        while(j<len2){
            if(s2[j]=='1'  && carry==1){
                carry=1;
                ans+='0';
            }
            else if((s2[j]=='1'  && carry==0) ||
               (s2[j]=='0'  && carry==1)
              ){
                carry=0;
                ans+='1';
            }
            else{
                ans+=s2[j];
            }
            j++;
        }
        while(i<len1){
            if(s1[i]=='1'  && carry==1){
                carry=1;
                ans+='0';
            }
            else if((s1[i]=='1'  && carry==0) ||
               (s1[i]=='0'  && carry==1)
              ){
                carry=0;
                ans+='1';
            }
            else{
                ans+=s1[i];
            }
            i++;
        }
        if(carry==1)ans+='1';
        reverse(ans.begin(),ans.end());
        for(int i=0;i<ans.length();i++){
            if(ans[i]!='0')return ans.substr(i);
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string A, B;
        cin >> A >> B;
        Solution ob;
        cout << ob.addBinary(A, B);
        cout << "\n";

        cout << "~"
             << "\n";
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends