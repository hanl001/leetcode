class Solution {
    public boolean oneEditAway(String first, String second) {
        //1. 长度相差不超过 1
        //2. 相同字符串个数不小于最大长度减 1
        int fLength = first.length();
        int sLength = second.length();
        if (fLength < sLength) {
            return oneEditAway(second, first);
        }

        int sub = fLength - sLength;
        if (sub > 1) {
            return false;
        }

        int sameCount = 0;
        int fIndex = 0, sIndex = 0;
        while (fIndex < fLength && sIndex < sLength) {
            if (first.charAt(fIndex) == second.charAt(sIndex)) {
                fIndex++;
                sIndex++;
                sameCount++;
            } else if (fLength == sLength) {
                fIndex++;
                sIndex++;
            } else {
                fIndex++;
            }
        }
        return fLength - sameCount <= 1;
    }
}
