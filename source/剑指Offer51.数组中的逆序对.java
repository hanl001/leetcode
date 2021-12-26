class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSortAndCount(nums, 0, nums.length - 1, temp);
    }

    private int mergeSortAndCount(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = mergeSortAndCount(nums, left, mid, temp);
        int rightCount = mergeSortAndCount(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return leftCount + rightCount;
        }
        int mergedCount = mergedAndCount(nums, left, mid, right, temp);
        return leftCount + rightCount + mergedCount;
    }

    private int mergedAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int l = left;
        int r = mid + 1;
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (l > mid) {
                nums[i] = temp[r++];
            } else if (r > right) {
                nums[i] = temp[l++];
            } else if (temp[l] <= temp[r]) {
                nums[i] = temp[l++];
            } else {
                nums[i] = temp[r++];
                count += mid + 1 - l;
            }
        }
        return count;
    }

    //timeout
    private int force(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    ++count;
                }
            }
        }
        return count;
    }
}
