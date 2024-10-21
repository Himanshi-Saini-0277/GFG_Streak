//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h> 
using namespace std; 


// } Driver Code Ends
//Back-end complete function Template for C++

class Solution{
    public:
    bool check(int pre[], int in[], int post[], int l1,int r1,int l2,int r2,int l3,int r3){
        if(l1>r1 && l2>r2 && l3>r3) return 1;
        if((r1-l1)!=(r2-l2) || (r1-l1)!=(r3-l3)) return 0;
        if(pre[l1]!=post[r3]) return 0;
        int ind;
        for(ind=l2;ind<=r2;ind++) if(in[ind]==pre[l1]) break;
        return ind<=r2 && check(pre,in,post,l1+1,l1+ind -l2,l2,ind-1,l3,l3+ ind -l2-1) &&
               check(pre,in,post,l1+ind -l2+1,r1,ind+1,r2,l3+ ind -l2, r3-1);
    }
    bool checktree(int preorder[], int inorder[], int postorder[], int N) 
    { 
         return check(preorder,inorder,postorder,0,N-1,0,N-1,0,N-1);
    }
};


//{ Driver Code Starts.

int main() 
{ 
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		int preorder[n];
		int inorder[n];
		int postorder[n];

		for (int i = 0; i < n; ++i)
			cin>>preorder[i];

		for (int i = 0; i < n; ++i)
			cin>>inorder[i];

		for (int i = 0; i < n; ++i)
			cin>>postorder[i];
        
        Solution obj;
		if(obj.checktree(preorder, inorder, postorder, n))
			cout << "Yes\n";
		else
			cout<<"No\n";
	} 
	return 0; 
} 


// } Driver Code Ends