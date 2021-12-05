class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineLetterCount = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int letterIndex = magazine.charAt(i) - 'a';
            magazineLetterCount[letterIndex]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int letterIndex = ransomNote.charAt(i) - 'a';
            if (magazineLetterCount[letterIndex] == 0) {
                return false;
            }
           --magazineLetterCount[letterIndex];
        }
        return true;
    }
}
