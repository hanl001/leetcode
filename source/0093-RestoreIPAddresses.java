class Solution {
    public List<String> restoreIpAddresses(String s) {
        helper(s, 0, s.length() - 1, new ArrayList<>());
        return list;
    }

    private List<String> list = new ArrayList<>();
    private void helper(String s, int l, int r, List<String> path) {
        if (l > r || path.size() == 4) {
            if (l > r && path.size() == 4) {
                String v = String.join(".", path);
                list.add(v);
            }
            return;
        }
        for (int i = l; i <= Math.min(l + 2, r); i++) {
            String subStr = s.substring(l, i + 1);
            if (isIpPoint(subStr)) {
                path.add(subStr);
                helper(s, i + 1, r, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isIpPoint(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int point = Integer.valueOf(s);
        return point <= 255;
    }
}
