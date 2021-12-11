class Solution {
    //public String reverseVowels(String s) {
    //    char[] chs = s.toCharArray();
    //    Set<String> set = Set.of("a", "e", "i", "o", "u", "A", "E", "I", "O", "U");
    //    int start = 0, end = chs.length - 1;
    //    while (start < end) {
    //        while (start < end && !set.contains(Character.toString(chs[start]))) {
    //            start++;
    //        }
    //        while (end > start && !set.contains(Character.toString(chs[end]))) {
    //            end--;
    //        }
    //        if (start >= end) {
    //            break;
    //        }
    //        char temp = chs[start];
    //        chs[start] = chs[end];
    //        chs[end] = temp;
    //        System.out.println(chs);
    //    }

    //    return new String(chs);
    //}

    public String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while (start < end) {
            while (start < end && !isVowels(s.charAt(start))) {
                start++;
            }
            while (end > start && !isVowels(s.charAt(end))) {
                end--;
            }
            if (start < end) {
                sb.setCharAt(start, s.charAt(end));
                sb.setCharAt(end, s.charAt(start));
                start++;
                end--;
            }
        }
        return sb.toString();
    }

    private boolean isVowels(char s) {
        return s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u'
        || s == 'A' || s == 'E' || s == 'I' || s == 'O' || s == 'U';
    }
}
