class Solution {
    public int mySqrt(int x) {
        long l = 0, r = x / 2 + x % 2;
        while (l <= r) {
            long mid = (l + r) >>> 1;
            long value = mid * mid;
            if (value == x) {
                return (int)mid;
            } else if (value < x) {
                long nextValue = (mid + 1) * (mid + 1);
                if (nextValue > x) {
                    return (int)mid;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int)l;
    }
}
