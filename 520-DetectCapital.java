class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }
        boolean theSecondIsUpperCase = Character.isUpperCase(word.charAt(1));
        if (Character.isLowerCase(word.charAt(0)) && theSecondIsUpperCase) {
            return false;
        }

        for (int i = 2; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i)) ^ theSecondIsUpperCase) {
                return false;
            }
        }
        return true;
    }
}
