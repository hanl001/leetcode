class Solution {
    public int multiply(int A, int B) {
        if (A > B) {
            return multiply(B, A);
        }

        // 除法/位运算 二分
        // return helper0(A, B);

        // 减法
        return helper1(A, B);
    }

    private int helper0(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return b;
        }

        // int half = multiply(a / 2, b);
        int half = multiply(a >> 1, b);
        // if (a % 2 == 1) {
        if ((a & 1) == 1) {
            return b + half + half;
        } else {
            return half + half;
        }
    }

    private int helper1(int a, int b) {
        if (a == 0) {
            return 0;
        }
        return b + helper1(a - 1, b);
    }
}
