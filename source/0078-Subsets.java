class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<Integer>());
        return list;
    }

    private List<List<Integer>> list = new ArrayList<>();
    private void helper(int[] nums, int i, List<Integer> path) {
        list.add(new ArrayList<>(path));
        if (i == nums.length) {
            return;
        }
        while (i < nums.length) {
            path.add(nums[i]);
            helper(nums, i + 1, path);
            path.remove(path.size() - 1);
            i++;
        }
    }
}
