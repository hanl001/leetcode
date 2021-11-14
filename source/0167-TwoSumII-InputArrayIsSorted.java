class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int value = numbers[start] + numbers[end];
            if (value < target) {
                ++start;
            } else if (value > target) {
                --end;
            } else {
                return new int[]{start + 1, end + 1};
            }
        }
        return null;
    }
}
