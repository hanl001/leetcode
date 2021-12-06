class Solution {
    // Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
    // 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
    public int superPow(int a, int[] b) {
        int mod = 1337;
        a = a % mod;
        int ret = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            ret = ret * pow(a, b[i], mod) % mod;
            a = pow(a, 10, mod);
        }
        return ret;
    }

    private int pow(int x, int n, int mod) {
        int ret = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ret = ret * x % mod;
            }
            x = x * x % mod;
            n /= 2;
        }
        return ret;
    }
}
