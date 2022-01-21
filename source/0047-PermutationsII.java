class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] bitMap = new boolean[nums.length];
        helper(nums, new ArrayList<Integer>(), bitMap);
        return list;
    }

    private List<List<Integer>> list = new ArrayList<>();
    private void helper(int[] nums, List<Integer> path, boolean[] bitMap) {
        if (path.size() == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!bitMap[i]) {
                if (i > 0 && bitMap[i - 1] && nums[i] == nums[i - 1]) {
                    continue;
                }
                path.add(nums[i]);
                bitMap[i] = true;
                helper(nums, path, bitMap);
                path.remove(path.size() - 1);
                bitMap[i] = false;
            }
        }
    }
}
