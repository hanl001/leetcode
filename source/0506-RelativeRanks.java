class Solution {
    /**
     * Input: score = [5,4,3,2,1]
     * Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
     * Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
     */
    public String[] findRelativeRanks(int[] score) {

        int[][] sorts = new int[score.length][2];
        for (int i = 0; i < score.length; i++) {
            sorts[i][0] = score[i];
            sorts[i][1] = i;
        }

        Arrays.sort(sorts, (a, b) -> b[0] - a[0]);

        String[] medals = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] ret = new String[score.length];
        for (int i = 0; i < sorts.length; i++) {
            int index = sorts[i][1];
            if (i > 2) {
                ret[index] = Integer.toString(i + 1);
            } else {
                ret[index] = medals[i];
            }
        }

        return ret;
    }
}
