class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int stackIndex = -1;
        int poppedIndex = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack[++stackIndex] = pushed[i];
            while (stackIndex > -1 && popped[poppedIndex] == stack[stackIndex]) {
                  poppedIndex++;
                  stackIndex--;
            }
        }
        return stackIndex == -1;
    }
}
