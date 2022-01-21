class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>());
        return list;
    }

    private List<List<Integer>> list = new ArrayList<>();
    private void helper(int[] nums, int i, List<Integer> path) {
        list.add(new ArrayList<>(path));
        for (int j = i; j < nums.length; j++) {
            if (j != i && nums[j] == nums[j - 1]) {
                continue;
            }
            path.add(nums[j]);
            helper(nums, j + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
