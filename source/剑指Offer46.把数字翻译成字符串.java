class Solution {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int length = str.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= length; i++) {
            String v = str.substring(i - 2, i);
            int number = Integer.parseInt(v);
            if (str.charAt(i - 2) == '0' || number > 25) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i], dp[i - 2] + dp[i - 1]);
            }
        }
        return dp[length];
    }
}
