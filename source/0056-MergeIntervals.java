class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] ret = new int[intervals.length][];
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (i == intervals.length - 1) {
                ret[count++] = intervals[i];
            } else {
                int[] cur = intervals[i];
                int[] next = intervals[i + 1];
                if (cur[1] >= next[0]) {
                    next[0] = cur[0];
                    if (cur[1] > next[1]) {
                        next[1] = cur[1];
                    }
                } else {
                    ret[count++] = cur;
                }
            }
        }
        return Arrays.copyOfRange(ret, 0, count);
    }
}
