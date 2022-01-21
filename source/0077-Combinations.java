class Solution {
    public List<List<Integer>> combine(int n, int k) {
        helper(n, new ArrayList<Integer>(), k, 1);
        return list;
    }

    private List<List<Integer>> list = new ArrayList<>();
    private void helper(int n, List<Integer> picked, int k, int i) {
        if (picked.size() == k) {
            list.add(new ArrayList<>(picked));
            return;
        }
        for (; i <= n - (k - picked.size()) + 1; i++) {
            picked.add(i);
            helper(n, picked, k, i + 1);
            picked.remove(picked.size() - 1);
        }
    }
}
