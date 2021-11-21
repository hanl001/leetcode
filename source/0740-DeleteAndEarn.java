/*
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * */
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        //Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //for (int num : nums) {
        //    int value = map.getOrDefault(num, 0) + 1;
        //    map.put(num, value);
        //}

        //int[] keys = new int[map.size()];
        //int ki = -1;
        //for (Integer key : map.keySet()) {
        //    keys[++ki] = key;
        //}
        //Arrays.sort(keys);

        //int dp0 = 0;
        //int dp1 = map.get(keys[0]) * keys[0];
        //for (int i = 1; i < keys.length; ++i) {
        //    int temp = dp1;
        //    if (keys[i] - keys[i - 1] == 1) {
        //        dp1 = Math.max(dp0 + map.get(keys[i]) * keys[i], dp1);
        //    } else {
        //        dp1 = dp1 + keys[i] * map.get(keys[i]);
        //    }
        //    dp0 = temp;
        //}
        //return dp1;

        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] sums = new int[maxVal + 1];
        for (int num : nums) {
            sums[num] += num;
        }

        int dp0 = sums[0];
        int dp1 = sums[1];
        for (int i = 2; i < sums.length; ++i) {
            int temp = dp1;
            dp1 = Math.max(dp0 + sums[i], dp1);
            dp0 = temp;
        }
        return dp1;
    }
}
