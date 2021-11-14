class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {           
            return dividend;
        }
        if (dividend == divisor) {
            return 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            // case: dividend = 2147483647, divisor = -2147483648
            // also, result is 0
            return 0;
        }
        if (divisor == Integer.MAX_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return -1;
            }
            return 0;
        }
        int remain = 0;
        if (Integer.MIN_VALUE == dividend) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }

            if (divisor < 0) {
                remain = 1;
                dividend -= divisor;
            } else {
                remain = -1;
                dividend += divisor;
            }
        }

        boolean sign = true;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            sign = false;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int currentDivisor = divisor;
        int result = 0;
        int index = 1;
        while (dividend >= currentDivisor) {
            dividend -= currentDivisor;
            result += index;
            index <<= 1;
            currentDivisor <<= 1;
            if (currentDivisor > dividend || currentDivisor < 0) {
                currentDivisor = divisor;
                index = 1;
            }
        }
      
        if (!sign) {
            result = -result;
        }
        result += remain;

        return result;
    }
}
