class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num / 2 + num % 2;
        while (l <= r) {
            long mid = (l + r) >>> 1;
            long value = mid * mid;
            if (value == num) {
                return true;
            } else if (value < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
