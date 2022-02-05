class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];

        if (obstacleGrid[0][0] == 0) {
            dp[0] = 1;
        }
        for (int j = 1; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[j] = 0;
            } else {
                dp[j] = dp[j - 1];
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    if (j > 0) {
                        dp[j] += dp[j - 1];
                    }
                }
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }
}
