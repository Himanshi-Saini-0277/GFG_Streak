class Solution {
  public:
    int diameter(int V, vector<vector<int>>& edges) {
        // Code here
        vector<vector<int>> adj(V);

        for (auto &e : edges) {

            adj[e[0]].push_back(e[1]);

            adj[e[1]].push_back(e[0]);

        }

        auto bfs = [&](int start) {

            vector<int> dist(V, -1);

            queue<int> q;

            q.push(start);

            dist[start] = 0;

            int farthestNode = start;

 

            while (!q.empty()) {

                int node = q.front();

                q.pop();

                for (int nei : adj[node]) {

                    if (dist[nei] == -1) {

                        dist[nei] = dist[node] + 1;

                        q.push(nei);

                        if (dist[nei] > dist[farthestNode]) {

                            farthestNode = nei;

                        }

                    }

                }

            }

            return make_pair(farthestNode, dist[farthestNode]);

        };


        auto first = bfs(0);

        auto second = bfs(first.first);

        return second.second;
    }
};
