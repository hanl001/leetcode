class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            dfs(graph, visited, path, i);
        }
        return canFinish;
    }

    private boolean canFinish = true;
    private void dfs(List<Integer>[] graph, boolean[] visited, boolean[] path, int i) {
        if (path[i]) {
            canFinish = false;
            return;
        }
        if (visited[i]) {
            return;
        }

        visited[i] = true;
        List<Integer> next = graph[i];
        if (next != null) {
            path[i] = true;
            for (int j : next) {
                dfs(graph, visited, path, j);
                if (!canFinish) {
                    return;
                }
            }
            path[i] = false;
        }
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int[] prerequisite : prerequisites) {
            List<Integer> next = graph[prerequisite[1]];
            if (next == null) {
                next = new ArrayList<>();
                graph[prerequisite[1]] = next;
            }
            next.add(prerequisite[0]);
        }
        return graph;
    }
}
