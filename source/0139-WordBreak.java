class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                String sub = s.substring(j, i);
                if (wordSet.contains(sub) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private boolean backtrack(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        helper(0, s, wordSet);
        return isMath;
    }

    private boolean isMath = false;
    private Set<Integer> memo = new HashSet<>();
    private void helper(int i, String s, Set<String> wordSet) {
        if (i == s.length()) {
            isMath = true;
            return;
        }
        for (int j = i + 1; j <= s.length(); j++) {
            String subStr = s.substring(i, j);
            if (wordSet.contains(subStr) && !memo.contains(j)) {
                memo.add(j);
                helper(j, s, wordSet);
                if (isMath) {
                    return;
                }
            }
        }
    }
}
