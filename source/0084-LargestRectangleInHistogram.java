//class Solution {
//    public int largestRectangleArea(int[] heights) {
//        int[] stack = new int[heights.length];
//        int stackIndex = -1;
//        int max = 0;
//        for (int i = 0; i < heights.length; i++) {
//            while (stackIndex > -1 && heights[stack[stackIndex]] > heights[i]) {
//                int height = heights[stack[stackIndex--]];
//                if (stackIndex == -1) {
//                    int cur = height * i;
//                    max = Math.max(max, cur);
//                } else {
//                    int cur = height * (i - stack[stackIndex] - 1);
//                    max = Math.max(max, cur);
//                }
//            }
//            stack[++stackIndex] = i;
//        }
//        while (stackIndex > -1) {
//            int height = heights[stack[stackIndex--]];
//            if (stackIndex == -1) {
//                int cur = height * heights.length;
//                max = Math.max(max, cur);
//            } else {
//                int cur = height * (heights.length - stack[stackIndex] - 1);
//                max = Math.max(max, cur);
//            }
//        }
//        return max;
//    }
//}

// 哨兵简化
class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        for (int i = 1; i < newHeights.length - 1; i++) {
            newHeights[i] = heights[i - 1];
        }
        heights = newHeights; // 设置前后哨兵

        int max = 0;
        int[] stack = new int[heights.length + 2];
        int stackIndex = -1;
        stack[++stackIndex] = 0; // 前哨兵保证栈不为空
        for (int i = 1; i < heights.length; i++) {
            // 后哨兵保证数据都能出栈
            while (heights[stack[stackIndex]] > heights[i]) {
                int height = heights[stack[stackIndex--]];
                int cur = height * (i - stack[stackIndex] - 1);
                max = Math.max(max, cur);
            }
            stack[++stackIndex] = i;
        }
        return max;
    }
}
