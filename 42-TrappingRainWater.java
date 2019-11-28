class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            if (leftHeight < rightHeight) {
                if (leftHeight >= leftMax) {
                    leftMax = leftHeight;
                } else {
                    result += leftMax - leftHeight;
                }
                ++left;
            } else {
                if (rightHeight >= rightMax) {
                    rightMax = rightHeight;
                } else {
                    result += rightMax - rightHeight;
                }
                --right;
            }
        }
        return result;
    }
}
