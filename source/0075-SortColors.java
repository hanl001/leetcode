class Solution {
    public void sortColors(int[] nums) {
        helper0(nums);
    }

    private void helper0(int[] nums) {
        int left = 0, right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 2) {
                nums[index] = nums[right];
                nums[right--] = 2;
            } else if (nums[index] == 0) {
                nums[index++] = 1;
                nums[left++] = 0;
            } else {
                index++;
            }
        }
    }

    private void helper1(int[] nums) {
        int left = 0, right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 2) {
                int temp = nums[index];
                nums[index] = nums[right];
                nums[right--] = temp;
            } else if (nums[index] == 0) { 
                int temp = nums[index];
                nums[index++] = nums[left];
                nums[left++] = temp;
            } else {
                index++;
            }
        }
    }

    // force
    private void helper2(int[] nums) {
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                leftCount++;
            }
            if (nums[i] == 2) {
                rightCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < leftCount) {
                nums[i] = 0;
            } else if (i >= nums.length - rightCount) {
                nums[i] = 2;
            } else {
                nums[i] = 1;
            }
        }
    }
}
