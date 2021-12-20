class Solution {
    public double myPow(double x, int n) {
        long m = n;
        if (m < 0) {
            x = 1 / x;
            m = -m;
        }

        // 备忘录报错：java.lang.NegativeArraySizeException
        // double[] memo = new double[m + 1];
        // return helper1(x, m, memo);

        // 法 1 递归
        // return helper1(x, m);

        // 法 2 快速幂
        return helper0(x, m);
    }

    private double helper0(double x, long n) {
        //2^0 + 2^1 + 2^2 + 2^3
        // 10 = 2^1 + 2^3
        // 3^10 = 3^2 * 3^8
        double ret = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ret *= x;
            }
            x *= x; // x^2 -> x^4 -> x^8 ...
            n = n / 2;
        }
        return ret;
    }

    // private double helper1(double x, int n, double[] memo) {
    private double helper1(double x, long n) {
        if (n == 0) {
            return 1;
        } 
        if (n == 1) {
            return x;
        }
        
        // if (memo[n] > 0) {
        //     return memo[n];
        // }

        // if (memo[n / 2] == 0) {
        //     memo[n / 2] = helper1(x, n / 2, memo);
        // }
        // if (n % 2 == 0) {
        //     memo[n] = memo[n / 2] * memo[n / 2];
        // } else {
        //     memo[n] = x * memo[n / 2] * memo[n / 2];
        // }
        // return memo[n];

        double pow = helper1(x, n / 2);
        if (n % 2 == 0) {
            return pow * pow;
        } else {
            return pow * pow * x;
        }
    }
}
