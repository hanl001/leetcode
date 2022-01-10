class Solution {
    public boolean verifyPostorder(int[] postorder) {
        helper(postorder, 0, postorder.length - 1);
        return isVerify;
    }

    private boolean isVerify = true;
    private void helper(int[] postorder, int l, int r) {
        if (l >= r) {
            return;
        }
        int rootVal = postorder[r];
        int i = l;
        for (; i < r && postorder[i] < rootVal; i++) {

        }
        int firstMaxIndex = i;
        for (; i < r && postorder[i] > rootVal; i++) {
        }
        if (i != r) {
            isVerify = false;
            return;
        }
        helper(postorder, l, firstMaxIndex - 1);
        if (!isVerify) {
            return;
        }
        helper(postorder, firstMaxIndex, r - 1);
    }
}
