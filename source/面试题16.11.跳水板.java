class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        // min -> k * shorter
        // max -> k * longer
        // step -> longer - shorter
        // count -> (max - min) / step + 1
        if (k == 0) {
            return new int[0];
        }

        if (shorter == longer) {
            int[] ret = new int[1];
            ret[0] = shorter * k;
            return  ret;
        }

        int[] ret = new int[k + 1];
        int min = k * shorter;
        for (int i = 0; i <= k; i++) {
            ret[i] = k * shorter + i * (longer - shorter);
        }
        return ret;
    }
}
