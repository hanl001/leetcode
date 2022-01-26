class Solution {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, Set<Integer>> vertices = new HashMap<>();
        for (int[] node : graph) {
            Set<Integer> set = vertices.getOrDefault(node[0], new HashSet<>());
            set.add(node[1]);
            vertices.put(node[0], set);
        }
        dfs(start, vertices, target, new boolean[n]);
        return isFind;
    }

    private boolean isFind = false;
    private void dfs(int i, Map<Integer, Set<Integer>> vertices, int target, boolean[] visited) {
        if (isFind) {
            return;
        }
        if (visited[i]) {
            return;
        }

        visited[i] = true;
        if (target == i) {
            isFind = true;
            return;
        }

        Set<Integer> set = vertices.getOrDefault(i, new HashSet<>());
        for (int j : set) {
            dfs(j, vertices, target, visited);
        }
    }
}
