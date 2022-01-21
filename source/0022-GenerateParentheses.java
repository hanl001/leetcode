class Solution {
    public List<String> generateParenthesis(int n) {
        char[] path = new char[n * 2];
        helper(n, n, 0, path);
        return list;
    }

    private List<String> list = new ArrayList<>();
    private void helper(int l, int r, int i, char[] path) {
        if (l == 0 && r == 0) {
            list.add(new String(path));
            return;
        }
        if (l > 0) {
            path[i] = '(';
            helper(l - 1, r, i +1, path);
        }
        if (r > 0 && l < r) {
            path[i] = ')';
            helper(l, r - 1, i + 1, path);
        }
    }
}
