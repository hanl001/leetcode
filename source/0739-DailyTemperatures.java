class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        int[] stack = new int[temperatures.length];
        int stackIndex = -1;
        for (int i = 0; i < temperatures.length; i++) {
            while (stackIndex > -1 && temperatures[stack[stackIndex]] < temperatures[i]) {
                ret[stack[stackIndex]] = i - stack[stackIndex];
                stackIndex--;
            }
            stack[++stackIndex] = i;
        }
        return ret;
    }
}
