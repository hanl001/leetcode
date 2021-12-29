class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && 
            (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if ((mid == 0 && nums[mid] < nums[mid + 1]) || 
            (nums[mid] > nums[mid - 1])) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
