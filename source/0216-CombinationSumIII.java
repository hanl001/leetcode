class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k, n, 1, new ArrayList<>());
        return list;
    }

    private List<List<Integer>> list = new ArrayList<>();
    private void helper(int k, int n, int i, List<Integer> path) {
        if (path.size() == k) {
            if (n == 0) {
                list.add(new ArrayList<>(path));
            }
            return;
        }
        
        for (int j = i; j <= 9 - (k - path.size()) + 1; j++) {
            if (j <= n) {
                path.add(j);
                helper(k, n - j, j + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
