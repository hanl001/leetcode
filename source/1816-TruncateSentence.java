class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                k--;
            }
            if (k > 0) {
               sb.append(s.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
