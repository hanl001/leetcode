//https://zhuanlan.zhihu.com/p/45008984
class Solution {
    public int getSum(int a, int b) {
        while ((b ^ 0) != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
