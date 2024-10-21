//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int Solve(int n, vector<vector<int>>& edge) {
        // code here
        if(edge.size()<(n-1)) return -1;
        vector<int> vis(n,0);
        int comp =0;
        int faltu = 0;
        vector<int> adj[n];
        sort(edge.begin(),edge.end());
        for(int i=1;i<edge.size();i++){
            if(edge[i-1][0]==edge[i][0] && edge[i-1][1]==edge[i][1]) faltu++;
        }
        for(int i=0;i<edge.size();i++){
            if(edge[i][0]!=edge[i][1]){
                adj[edge[i][0]].push_back(edge[i][1]);
                adj[edge[i][1]].push_back(edge[i][0]);
            }else faltu++;
            
        }
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                comp++;
                queue<pair<int,int>> q;
                q.push({i,-1});
                
                while(!q.empty()){
                    int node = q.front().first;
                    int par = q.front().second;
                    q.pop();
                    vis[node]=1;
                    for(auto it: adj[node]){
                        if(vis[it]==1){
                            if(it!=par) faltu++;
                        }else{
                            q.push({it,node});
                            vis[it]=1;
                        }
                    }
                }
            }
        }
        if(faltu>=(comp-1)) return comp-1;
        return -1;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> adj;

        for (int i = 0; i < m; ++i) {
            vector<int> temp;
            for (int j = 0; j < 2; ++j) {
                int x;
                cin >> x;
                temp.push_back(x);
            }
            adj.push_back(temp);
        }

        Solution Obj;
        cout << Obj.Solve(n, adj) << "\n";
    }
    return 0;
}
// } Driver Code Ends