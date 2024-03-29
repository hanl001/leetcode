class Solution {
    public int minDistance(String word1, String word2) {
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
        int[][] dp = new int[char1.length + 1][char2.length + 1];
        for (int i = 0; i <= char1.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= char2.length; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= char1.length; i++) {
            for (int j = 1; j <= char2.length; j++) {
                if (char1[i - 1] == char2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[char1.length][char2.length];
    }
}
