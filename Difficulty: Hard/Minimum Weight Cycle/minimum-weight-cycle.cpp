//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Pair {
public:
    int node, weight;
    Pair(int node, int weight) : node(node), weight(weight) {}

    bool operator<(const Pair& other) const {
        if (node != other.node)
            return node < other.node;
        return weight < other.weight;
    }
};

class Solution {
private:
    int dijkstra(int src, int dest, int V, const vector<set<Pair>>& adj) {
        vector<int> dist(V, INT_MAX);
        dist[src] = 0;

        typedef pair<int, int> pii;
        priority_queue<pii, vector<pii>, greater<pii>> pq;
        pq.push(make_pair(0, src));

        while (!pq.empty()) {
            pii top = pq.top(); pq.pop();
            int d = top.first;
            int u = top.second;

            if (d > dist[u]) continue;

            for (const Pair& nei : adj[u]) {
                if (dist[nei.node] > dist[u] + nei.weight) {
                    dist[nei.node] = dist[u] + nei.weight;
                    pq.push(make_pair(dist[nei.node], nei.node));
                }
            }
        }

        return dist[dest];
    }

public:
    int findMinCycle(int V, vector<vector<int>>& edges) {
        vector<set<Pair>> adj(V);

        for (const auto& edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj[u].insert(Pair(v, w));
            adj[v].insert(Pair(u, w));
        }

        int ans = INT_MAX;

        for (const auto& edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];

            adj[u].erase(Pair(v, w));
            adj[v].erase(Pair(u, w));

            int minDist = dijkstra(u, v, V, adj);
            if (minDist != INT_MAX) {
                ans = min(ans, minDist + w);
            }

            adj[u].insert(Pair(v, w));
            adj[v].insert(Pair(u, w));
        }

        return (ans == INT_MAX ? -1 : ans);
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int V, E;
        cin >> V >> E;
        vector<vector<int>> edges;
        int i = 0;
        while (i++ < E) {
            int u, v, w;
            cin >> u >> v >> w;
            edges.push_back({u, v, w});
            edges.push_back({v, u, w});
        }

        Solution obj;
        int res = obj.findMinCycle(V, edges);

        cout << res << endl;
    }

    return 0;
}
// } Driver Code Ends