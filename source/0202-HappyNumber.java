class Solution {
    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = helper(n, map);
        return ret == 1;
    }

    private int helper(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int ret = 0;
        int cur = n;
        while (cur > 0) {
            int remain = cur % 10;
            cur = cur / 10;
            ret += remain * remain;
        }
        map.put(n, ret);
        return helper(ret, map);
    }
}
