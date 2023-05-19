package org.example;

import java.util.*;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> visited = new HashSet<>();
        boolean result = false;
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();

        Stack<Integer> nodes = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length != 0) {
                nodes.push(i);
                break;
            }
        }

        int switcher = 1;
        while (!nodes.isEmpty()) {
            int current = nodes.pop();
            visited.add(current);
            if (switcher == 1) {
                firstSet.add(current);
                for (int i = 0; i < graph[current].length; i++) {
                    if (firstSet.contains(graph[current][i])) {
                        return false;
                    }
                }
                switcher *= -1;
            } else if (switcher == -1) {
                secondSet.add(current);
                for (int i = 0; i < graph[current].length; i++) {
                    if (secondSet.contains(graph[current][i])) {
                        return false;
                    }
                }
                switcher *= -1;
            }
            for (int i = 0; i < graph[current].length; i++) {
                if (!visited.contains(graph[current][i])) {
                    nodes.push(graph[current][i]);
                    break;
                }
            }
        }
        return true;
    }

}
