class Solution {

    // 递减栈
    public int trap(int[] height) {
        int[] stack = new int[height.length];
        int stackIndex = -1;
        int ret = 0;
        for (int i = 0; i < height.length; i++) {
            while (stackIndex > -1 && height[i] > height[stack[stackIndex]]) {
                int bottom = stack[stackIndex--];
                if (stackIndex == -1) {
                    break;
                }
                int left = stack[stackIndex];
                int w = i - left - 1;
                int h = Math.min(height[i], height[left]) - height[bottom];
                ret += w * h;
            }
            stack[++stackIndex] = i;
        }
        return ret;
    }

    // 双指针
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMaxHeight = 0, rightMaxHeight = 0;
        int result = 0;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            if (leftHeight < rightHeight) {
                if (leftHeight >= leftMaxHeight) {
                    leftMaxHeight = leftHeight;
                } else {
                    result += leftMaxHeight - leftHeight;
                }
                ++left;
            } else {
                if (rightHeight >= rightMaxHeight) {
                    rightMaxHeight = rightHeight;
                } else {
                    result += rightMaxHeight - rightHeight;
                }
                --right;
            }
        }
        return result;
    }
}
