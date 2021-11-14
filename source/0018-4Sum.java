class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // fix case:
            // [-5,-5,-3,-1,0,2,4,5]
            // -7
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int firstValue = nums[i];
            // three sum
            int threeSumTarget = target - firstValue;
            for (int j = i + 1; j < nums.length; j++) {
                // fix case:
                // [-3,-2,-1,0,0,1,2,3]
                // 0
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int secondValue = nums[j];
                // two sum
                int twoSumTarget = threeSumTarget - secondValue;
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int twoSum = nums[start] + nums[end];
                    if (twoSum == twoSumTarget) {
                        result.add(Arrays.asList(firstValue, secondValue, nums[start], nums[end]));
                        // remove duplication
                        while (start < end) {
                            if (nums[start] != nums[++start]) {
                               break; 
                            }
                        }
                        while (start < end) {
                            if (nums[end] != nums[--end]) {
                               break; 
                            }
                        }
                    } else if (twoSum < twoSumTarget) {
                        ++start;
                    } else {
                        --end;
                    }
                }
            }
        }

        return result;
    }
}
