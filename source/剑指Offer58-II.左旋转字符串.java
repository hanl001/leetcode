class Solution {
    public String reverseLeftWords(String s, int n) {
        n = Math.min(s.length(), n);
        //法1. 分次遍历
        //StringBuilder sb = new StringBuilder();
        //for (int i = n; i < s.length(); i++) {
        //    sb.append(s.charAt(i));
        //}
        //for (int i = 0; i < n; i++) {
        //    sb.append(s.charAt(i));
        //}
        //return sb.toString();
        //法2. 直接截取
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
