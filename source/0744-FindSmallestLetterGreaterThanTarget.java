class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            char value = letters[mid];
            if ((mid == 0 && value > target) ||
             (mid > 0 && value > target && letters[mid - 1] <= target)) {
                return value;
            } else if (value <= target) {
                if (mid == letters.length - 1) {
                    return letters[0];
                } else {
                    l = mid + 1;
                }
            } else {
                r = mid - 1;
            }
        }
        return ' ';
    }
}
