//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution {

public:
    int drow[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
    int dcol[8] = {-1, 0, 1, -1, 1, -1, 0, 1};

    // Function to check if the cell is valid for DFS
    bool isValid(vector<vector<char>>& grid, int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == '1';
    }
    
    void dfs(vector<vector<char>>& grid, int row, int col, int n, int m) {
        grid[row][col] = '0';

        for (int i = 0; i < 8; i++) {

            int newr = row + drow[i];
            int newc = col + dcol[i];

            if (isValid(grid, newr, newc, n, m)) {
                dfs(grid, newr, newc, n, m);
            }
        }
    }

    int numIslands(vector<vector<char>>& grid) {
        int count = 0;
        int n = grid.size();
        int m = grid[0].size();
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }
};


//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, m;
        cin >> n >> m;
        vector<vector<char>> grid(n, vector<char>(m, '#'));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> grid[i][j];
            }
        }
        Solution obj;
        int ans = obj.numIslands(grid);
        cout << ans << '\n';
    }
    return 0;
}
// } Driver Code Ends