class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int value = nums[l] + nums[r];
                if (value == target) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[l++]);
                    item.add(nums[r--]);
                    list.add(item);
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (value > target) {
                    r--;
                } else {
                    l++;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return list;
    }

    private List<List<Integer>> helper(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(nums[j])) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[map.get(nums[j])]);
                    item.add(nums[j]);
                    list.add(item);
                }
                map.put(target - nums[j], j);
            }
        }
        //TODO: remove duplicate
        return list;
    }
}
