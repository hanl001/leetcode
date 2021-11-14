class Solution {
    // T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
    public int tribonacci(int n) {
        int t0 = 0, t1 = 1, t2 = 1;

        if (n == 0) {
            return t0;
        }
        if (n == 1) {
            return t1;
        }

        for (int i = 3; i <= n; ++i) {
            int tn = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }
        return t2;
    }
}
