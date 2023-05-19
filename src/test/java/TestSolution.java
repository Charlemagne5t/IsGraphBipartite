import org.example.Solution;
import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // 0: not colored, 1: color 1, -1: color -1

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) { // Node not colored
                if (!dfs(graph, i, 1, colors)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int node, int color, int[] colors) {
        colors[node] = color;

        for (int neighbor : graph[node]) {
            if (colors[neighbor] == color) {
                return false; // Conflict in colors
            }
            if (colors[neighbor] == 0 && !dfs(graph, neighbor, -color, colors)) {
                return false; // Recursive call with the opposite color
            }
        }

        return true;
    }
}