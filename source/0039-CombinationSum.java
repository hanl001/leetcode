class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, new ArrayList<>(), 0);
        return list;
    }

    private List<List<Integer>> list = new ArrayList<>();
    private void helper(int[] candidates, int target, List<Integer> path, int i) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            list.add(new ArrayList<Integer>(path));
            return;
        }
        while (i < candidates.length) {
            int candidate = candidates[i];
            if (candidate <= target) {
                path.add(candidate);
                helper(candidates, target - candidate, path, i);
                path.remove(path.size() - 1);
            }
            i++;
        }
    }
}
