class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 程序的鲁棒性
        if (nums.length < 2) {
            return null;
        }

        // 1: 暴力 n * n -> n * n / 2
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; i < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        // 2: 空间换时间 降维
        // O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++j) {
            if (map.get(target - nums[i])) {
                return new int[]{map.get(nums[i]), map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }

        // 3: 双指针
        // nlog(n)
        int[] tempNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tempNums);

        int[] tempResult;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int value = tempNums[start] + tempNums[end];
            if (value < target) {
                ++start;
            } else if (value > target) {
                --end;
            } else {
                tempResult[0] = tempNums[start];
                tempResult[1] = tempNums[end];
                break;
            }
        }
        if (tempResult == null) {
            return null;
        }

        for (int i = 0; i < nums.length; ++j) {
            if (nums[i] == tempResult[0]) {
                result[0] = i;
            } else if (nums[i] == tempResult[1]) {
                result[1] = i;
            }
        }

        // i++ 与 ++i
        int i = 5;
        int x = i++;
        int temp_i = i; // 需要生成临时变量
        i = i + 1;
        x = tem_id;
        // i = 6, x = 5

        int i = 5;
        int x = ++i;
        i = i + 1;
        x = i;
        // i = 6, x = 6

        return null;
    }
}
