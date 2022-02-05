class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                if (j == 0) {
                    dp[j] += list.get(j);
                } else if (j == list.size() - 1) {
                    dp[j] = dp[j - 1] + list.get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + list.get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int v : dp) {
            min = Math.min(v, min);
        }
        return min;
    }
}
