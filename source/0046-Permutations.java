class Solution {
    public List<List<Integer>> permute(int[] nums) {
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
        for (int j = 0; j < nums.length; j++) {
            if (!bitMap[j]) {
                path.add(nums[j]);
                bitMap[j] = true;
                helper(nums, path, bitMap);
                path.remove(path.size() - 1);
                bitMap[j] = false;
            }
        }
    }
}
