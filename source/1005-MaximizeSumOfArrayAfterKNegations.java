class Solution {
    /*
     * 1 <= nums.length <= 10^4
     * -100 <= nums[i] <= 100
     * 1 <= k <= 10^4
     * */
    public int largestSumAfterKNegations(int[] nums, int k) {
        int minNum = 100;
        int[] counts = new int[201];
        for (int num : nums) {
            counts[num + 100]++;
            if (Math.abs(num) < Math.abs(minNum)) {
                minNum = num;
            }
        }

        int sum = 0;
        int i = 0;
        while (true) {
            int count = counts[i];
            while (count > 0 && k > 0) {
                sum += 100 - i;
                count--;
                k--;
            }
            counts[i] = count;

            if (i == 99 || k == 0) {
                break;
            }
            i++;
        }

        if (k % 2 == 1) {
            if (minNum < 0) {
                sum += 2 * minNum;
            } 
            if (minNum > 0) {
                sum -= minNum;
                counts[minNum + 100]--;
            }
        }

        for (int j = i; j < 201; j++) {
             int count = counts[j];
             int num = j - 100;
             while (count > 0) {
                 sum += num;
                 count--;
             }
        }

        return sum;
    }
}
