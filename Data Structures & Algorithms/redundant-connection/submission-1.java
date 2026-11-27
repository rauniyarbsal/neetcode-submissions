class Solution {

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        // Initially every node is its own parent/root
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Process edges in input order
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // If union fails, u and v were already connected
            // so this edge creates the cycle
            if (!union(u, v, parent)) {
                return edge;
            }
        }

        return new int[0];
    }

    // Find root with path compression
    public int find(int node, int[] parent) {

        if (parent[node] != node) {
            parent[node] = find(parent[node], parent);
        }

        return parent[node];
    }

    public boolean union(int u, int v, int[] parent) {

        int rootU = find(u, parent);
        int rootV = find(v, parent);

        // Already belong to same component
        // Adding this edge would create a cycle
        if (rootU == rootV) {
            return false;
        }

        // Merge the two components
        parent[rootV] = rootU;

        return true;
    }
}