class Solution {
    
    // 暴力法
    public int trap(int[] height) {
        int ret = 0;
        // 第一个和最后一个不可能接到雨水
        for (int i = 1; i < height.length - 1; i++) {
            int curHeight = height[i];
            int leftMax = 0;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(height[j], leftMax);
            }
            int rightMax = 0;
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(height[j], rightMax);
            }
            int value = Math.min(leftMax, rightMax) - curHeight;
            if (value > 0) {
                ret += value;
            }
        }
        return ret;
    }
    
    // 前缀后缀 max 统计
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i++) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int[] rightMax = new int[height.length];
        int ret = 0;
        // 第一个和最后一个不可能接到雨水
        for (int i = 1; i < height.length - 1; i++) {
            int curHeight = height[i];
            int value = Math.min(leftMax[i], rightMax[i]) - curHeight;
            ret += value;
        }
        return ret;
    }

    // 递减栈
    public int trap(int[] height) {
        int[] stack = new int[height.length];
        int stackIndex = -1;
        int ret = 0;
        for (int i = 0; i < height.length; i++) {
            while (stackIndex > -1 && height[i] > height[stack[stackIndex]]) {
                int bottom = stack[stackIndex--];
                if (stackIndex == -1) { // 边界无法操作
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
