class Solution {
    public boolean isPalindrome(int x) {
        int reversed = 0;
        int leaved = x;
        while (leaved > 0) {
            reversed = reversed * 10 + leaved % 10;
            leaved /= 10;
        }
        return reversed == x;
    }
}
