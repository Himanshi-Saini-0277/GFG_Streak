//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution
{
    public:
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    int minimumCostPath(vector<vector<int>>& grid) 
    {
        // Code here
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>>pq;
         int n = grid.size();
         int m = grid[0].size();
         vector<vector<int>>vis(n, vector<int>(m, 0));
          vector<vector<int>>dist(n, vector<int>(m, INT_MAX));
         int row[4]={-1, 0, 1, 0};
         int col[4]={0, 1, 0, -1};
         pq.push({grid[0][0],{0, 0}});
         dist[0][0]=grid[0][0];
         
        
       
         while(!pq.empty())
         {    
             int r= pq.top().second.first;
             int c= pq.top().second.second;
             
            
             pq.pop();
             if(vis[r][c])
             continue;
             vis[r][c]=1;
             
             for(int i =0;i<4; i++)
             {
                  int x= r+ row[i];
                  int y= c+ col[i];
                  if(x>=0 && y>=0 && x< n&& y< m)
                  {
                      if(dist[x][y] > dist[r][c]+ grid[x][y])
                      {
                           dist[x][y]= dist[r][c]+ grid[x][y];
                           pq.push({dist[x][y],{x, y}});
                      }
                  }
                  
             }
             
             
         }
         return dist[n-1][m-1];
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<vector<int>>grid(n, vector<int>(n, -1));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				cin >> grid[i][j];
			}
		}
		Solution obj;
		int ans = obj.minimumCostPath(grid);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends