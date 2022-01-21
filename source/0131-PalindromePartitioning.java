class Solution {
    public List<List<String>> partition(String s) {
        helper(s, 0, s.length() - 1, new ArrayList<>());
        return list;
    }

    private List<List<String>> list = new ArrayList<>();
    private void helper(String s, int l, int r, List<String> path) {
        if (l > r) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = l; i <= r; i++) {
            if (isPartition(s, l, i)) {
                path.add(s.substring(l, i + 1));
                helper(s, i + 1, r, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPartition(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
