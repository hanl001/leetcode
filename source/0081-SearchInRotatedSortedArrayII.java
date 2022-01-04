class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int value = nums[mid];
            if (value == target) {
                return true;
            } else if (target > value) {
                if (value > nums[nums.length - 1]) {
                    l = mid + 1;
                } else if (value < nums[nums.length - 1]){
                    if (target > nums[nums.length - 1]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else { // value == nums[nums.length - 1]
                    while (nums[l] == value  && r > l) {
                        l++;
                    }
                    while (nums[r] == value && r > l) {
                        r--;
                    }
                    if (r == l) {
                        return nums[r] == target;
                    }
                }
            } else { // target < value
                if (value > nums[nums.length - 1]) {
                    if (target > nums[nums.length - 1]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else if (value < nums[nums.length - 1]){
                    r = mid - 1;
                } else { // value == nums[nums.length - 1]
                    // 法 1
                    //boolean isLeftSame = true;
                    //for (int i = l; i <= mid; i++) {
                    //    if (value != nums[i]) {
                    //        isLeftSame = false;
                    //        break;
                    //    }
                    //}
                    //if (isLeftSame) {
                    //    l = mid + 1;
                    //} else {
                    //    r = mid - 1;
                    //}
                    // 法 2
                    while (nums[l] == value  && r > l) {
                        l++;
                    }
                    while (nums[r] == value && r > l) {
                        r--;
                    }
                    if (r == l) {
                        return nums[r] == target;
                    }
                }
            }
        }
        return false;
    }
}
