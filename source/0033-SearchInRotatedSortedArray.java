class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int value = nums[mid];
            if (value == target) {
                return mid;
            } else {
                if (nums[0] <= nums[nums.length - 1]) {
                    if (value > target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else if (value >= nums[0]) {
                    if (target > value) {
                        l = mid + 1;
                    } else {
                        if (target <= nums[nums.length - 1]) {
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    }
                } else {
                    if (target < value) {
                        r = mid - 1;
                    } else {
                        if (target > nums[nums.length - 1]) {
                            r = mid - 1;
                        } else {
                            l = mid + 1;
                        }
                    }
                }
            } 
        }
        return -1;
    }
}
