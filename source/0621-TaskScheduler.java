class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        int[] count = new int[26];
        for (char c : tasks) {
            ++count[c - 'A'];
        }

        Arrays.sort(count);
        int i = 25;
        while (i >= 0) {
            if (count[i] == count[25]) {
                --i;
            } else {
                break;
            }
        }

        return Math.max(tasks.length, count[25] + n * (count[25] - 1) + 25 - i - 1);
    }
}
