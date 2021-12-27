class Solution {
    public int search(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int value = nums[mid];
            if (value == target) {
                return mid;
            } else if (value > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

