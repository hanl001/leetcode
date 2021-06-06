class Solution {
    public int hammingDistance(int x, int y) {
        int value = x ^ y;
        return Integer.bitCount(value);
    }
}
