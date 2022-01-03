class Solution {
    public int[] findSwapValues(int[] array1, int[] array2) {
        Set<Integer> set1 = new HashSet<>();
        int sum1 = 0;
        for (int v : array1) {
            sum1 += v;
            set1.add(v);
        }
        Set<Integer> set2 = new HashSet<>();
        int sum2 = 0;
        for (int v : array2) {
            sum2 += v;
            set2.add(v);
        }
        int target = sum2 - sum1;
        if (target % 2 == 1) {
            return new int[0];
        }
        for (int v : set1) {
            int v2 = target / 2 + v;
            if (set2.contains(v2)) {
                return new int[]{v, v2};
            }
        }
        return new int[0];
    }
}
