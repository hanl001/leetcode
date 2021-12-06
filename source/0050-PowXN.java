class Solution {
    public double myPow(double x, int n) {
        long m = n;
        if (n < 0) {
            m = -m;
            x = 1.0 / x;
        }

        double ret = 1;
        while (m > 0) {
            if (m % 2 == 1) {
                ret *= x;
            }
            x *= x;
            m /= 2;
        }
        return ret;
    }
}
