class Solution {

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        dfs(arr, start, visited);
        return canReach;
    }

    private boolean canReach = false;
    private void dfs(int[] arr, int i, boolean[] visited) {
        if (canReach) {
            return;
        }
        if (i < 0 || i >= arr.length) {
            return;
        }
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        if (arr[i] == 0) {
            canReach = true;
            return;
        }
        dfs(arr, i + arr[i], visited);
        dfs(arr, i - arr[i], visited);
    }
}
