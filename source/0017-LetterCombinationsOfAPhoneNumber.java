class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return list;
        }
        helper(digits, new StringBuilder(), 0);
        return list;
    }

    private List<String> list = new ArrayList<>();
    private String[] keypad = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private void helper(String digits, StringBuilder sb, int i) {
        if (i == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String str = keypad[digits.charAt(i) - '2'];
        for (int j = 0; j < str.length(); j++) {
            sb.append(str.charAt(j));
            helper(digits, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
