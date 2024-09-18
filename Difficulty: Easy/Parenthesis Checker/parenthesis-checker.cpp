//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution
{
    public:
    //Function to check if brackets are balanced or not.
    bool ispar(string x)
    {
        // Your code here
        stack<char>st;
        
        for(int i=0;i<x.size();i++){
            
            if(x[i]=='(') st.push(x[i]);
            else if(x[i]=='{') st.push(x[i]);
            else if(x[i]=='[') st.push(x[i]);
            
            else if((x[i]==')' ||  x[i]=='}' || x[i]==']') && st.empty()) return false;
            
            else if(x[i]==')' and st.top()=='(') st.pop();
            else if(x[i]=='}' and st.top()=='{') st.pop();
            else if(x[i]==']' and st.top()=='[') st.pop();
            
            else return false;
        }
        if(!st.empty()) return false;
        return true;
    }

};

//{ Driver Code Starts.

int main()
{
   int t;
   string a;
   cin>>t;
   while(t--)
   {
       cin>>a;
       Solution obj;
       if(obj.ispar(a))
        cout<<"balanced"<<endl;
       else
        cout<<"not balanced"<<endl;
   }
}
// } Driver Code Ends