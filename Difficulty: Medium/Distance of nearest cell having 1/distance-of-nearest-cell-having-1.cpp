class Solution {
  public:
    vector<vector<int>> nearest(vector<vector<int>>& grid) {
        // code here
        int x=grid.size();
        int y=grid[0].size();
        vector<vector<int>>visited(x,vector<int>(y,0));
         vector<vector<int>>final(x,vector<int>(y,0));
         deque<pair<pair<int,int>,int>>q;
         
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(grid[i][j]==1){
                    visited[i][j]=1;
                    q.push_back({{i,j},0});
                }
            }
        }
        
        while(!q.empty()){
            auto it=q.front();
            q.pop_front();
            if(it.second!=0){
                final[it.first.first][it.first.second]=it.second;
            }
            
            if(it.first.first-1>=0){
                if(visited[it.first.first-1][it.first.second]==0){
                    q.push_back({{it.first.first-1,it.first.second},it.second+1});
                    visited[it.first.first-1][it.first.second]=1;
                }
            }
            
             if(it.first.first+1<x){
                if(visited[it.first.first+1][it.first.second]==0){
                    q.push_back({{it.first.first+1,it.first.second},it.second+1});
                    visited[it.first.first+1][it.first.second]=1;
                    
                }
            }
            
            
             if(it.first.second-1>=0){
                if(visited[it.first.first][it.first.second-1]==0){
                    q.push_back({{it.first.first,it.first.second-1},it.second+1});
                     visited[it.first.first][it.first.second-1]=1;
                    
                }
            }
            
            
             if(it.first.second+1<y){
                if(visited[it.first.first][it.first.second+1]==0){
                    q.push_back({{it.first.first,it.first.second+1},it.second+1});
                    visited[it.first.first][it.first.second+1]=1;
                    
                }
            }
            
        }
        
        return final;
    }
};