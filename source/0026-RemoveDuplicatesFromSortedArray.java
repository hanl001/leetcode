class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        //法1
        //int start = 1, end = 1;
        //while (end < nums.length) {
        //    if (nums[end - 1] != nums[end]) {
        //        nums[start++] = nums[end];
        //    }
        //    end++;
        //}
        //return start;

        //法2 ++start 100 pass
        int start = 0, end = 1;
        while (end < nums.length) {
            if (nums[start] != nums[end]) {
                nums[++start] = nums[end];
            }
            end++;
        }
        return start + 1;
    }
}
