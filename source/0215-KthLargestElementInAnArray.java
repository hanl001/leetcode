class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    private int findKthLargest(int[] nums, int left, int right, int index) {
        return helper0(nums, left, right, index);
    }

    private int helper0(int[] nums, int left, int right, int index) {
        while (left < right) {
            int i = random.nextInt(right - left) + left;
            int temp = nums[right];
            nums[right] = nums[i];
            nums[i] = temp;
            int curIndex = partition0(nums, left, right);
            if (curIndex > index) {
                right = curIndex - 1;
            } else if (curIndex < index) {
                left = curIndex + 1;
            } else {
                break;
            }
        }
        return nums[index];
    }

    private int partition0(int[] nums, int left, int right) {
        int value = nums[right];
        while (left < right) {
            while (left < right && nums[left] >= value) {
                left++;
            }
            if (left < right) {
                nums[right--] = nums[left];
            }
            while (left < right && nums[right] < value) {
                right--;
            }
            if (left < right) {
                nums[left++] = nums[right];
            }
        }
        nums[left] = value;
        return left;
    }

    private Random random = new Random();
    private int helper(int[] nums, int left, int right, int index) {
        if (left == right) { // fix java random error
            return nums[left];
        }
        
        int i = random.nextInt(right - left) + left;
        int temp = nums[right];
        nums[right] = nums[i];
        nums[i] = temp;

        int curIndex = partition(nums, left, right);
        if (curIndex > index) {
            return findKthLargest(nums, left, curIndex - 1, index);
        } else if (curIndex < index) {
            return findKthLargest(nums, curIndex + 1, right, index);
        } else {
            return nums[curIndex];
        }
    }

    private int partition(int[] nums, int left, int right) {
        int cur = nums[right];
        int index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] >= cur) {
                int temp = nums[index];
                nums[index++] = nums[i];
                nums[i] = temp;
            }
        }
        nums[right] = nums[index];
        nums[index] = cur;
        return index;
    }
}
