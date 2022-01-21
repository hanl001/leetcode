class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<Integer>());
        return list;
    }

    private List<List<Integer>> list = new ArrayList<>();
    private void helper(int[] candidates, int target, int i, List<Integer> path) {
        if (target == 0) {
            list.add(new ArrayList<Integer>(path));
            return;
        }
        int j = i;
        while (i < candidates.length) {
            int candidate = candidates[i];
            if (i > j && candidate == candidates[i - 1]) {
                i++;
                continue;
            }
            if (candidate <= target) {
                path.add(candidate);
                helper(candidates, target - candidate, i + 1, path);
                path.remove(path.size() - 1);
            }
            i++;
        }
    }
}
