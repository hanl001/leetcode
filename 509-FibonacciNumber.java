class Solution {
    /*
        F(0) = 0，F(1) = 1
        F(n) = F(n - 1) + F(n - 2)，其中 n > 1
    */
    public int fib(int n) {
        int f0 = 0, f1 = 1;
        if (n == 0) {
            return f0;
        }

        for (int i = 2; i <= n; ++i) {
            int fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return f1;
    }
}
