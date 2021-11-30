class Solution {
    public int[] masterMind(String solution, String guess) {
        int[] count = new int[4];
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                ans1++;
            }
            if (solution.charAt(i) == 'R') {
                count[0]++;
            }
            if (solution.charAt(i) == 'G') {
                count[1]++;
            }
            if (solution.charAt(i) == 'B') {
                count[2]++;
            }
            if (solution.charAt(i) == 'Y') {
                count[3]++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == 'R' && count[0] > 0) {
                count[0]--;
                ans2++;
            }
            if (guess.charAt(i) == 'G' && count[1] > 0) {
                count[1]--;
                ans2++;
            }
            if (guess.charAt(i) == 'B' && count[2] > 0) {
                count[2]--;
                ans2++;
            }
            if (guess.charAt(i) == 'Y' && count[3] > 0) {
                count[3]--;
                ans2++;
            }
        }

        int[] ret = new int[2];
        ret[0] = ans1;
        ret[1] = ans2 - ans1;
        return ret;
    }
}
