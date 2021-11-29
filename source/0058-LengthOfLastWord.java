class Solution {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int end = chars.length - 1;
        int count = 0;
        while (end >= 0 && !Character.isLetterOrDigit(chars[end])) {
            end--;
        }
        while (end >= 0 && Character.isLetterOrDigit(chars[end])) {
            end--;
            count++;
        }
        return count;
    }
}
