class Solution {
    public int[] pondSizes(int[][] land) {
        if (land.length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                   int c = dfs(land, i, j);
                   list.add(c);
                }
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        Arrays.sort(ret);
        return ret;
    }

    private int dfs(int[][] land, int i, int j) {
        if (i >= land.length || i < 0 || j >= land[0].length || j < 0 || land[i][j] != 0) {
            return 0;
        }
        land[i][j] = -1;
        return 1 + dfs(land, i - 1, j) 
        + dfs(land, i - 1, j - 1)
        + dfs(land, i - 1, j + 1)
        + dfs(land, i, j + 1)
        + dfs(land, i, j - 1)
        + dfs(land, i + 1, j) 
        + dfs(land, i + 1, j + 1)
        + dfs(land, i + 1, j - 1);
    }
}
