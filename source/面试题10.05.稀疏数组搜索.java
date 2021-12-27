class Solution {
    public int findString(String[] words, String s) {
        int l = 0, r = words.length - 1;
        return findString(words, s, l, r);
    }

    private int findString(String[] words, String s, int l, int r) {
        while (l <= r) {
            int mid = (l + r) >>> 1;
            String value = words[mid];
            
            if (value.equals("")) {
                int leftRet = findString(words, s, l, mid - 1);
                if (leftRet != -1) {
                    return leftRet;
                }
                return findString(words, s, mid + 1, r);
            }

            int ret = value.compareTo(s);
            if (ret == 0) {
                return mid;
            } else if (ret > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}

class Solution {
    public int findString(String[] words, String s) {
        int l = 0, r = words.length - 1;
        Random random = new Random();
        return findString(words, s, l, r, random);
    }

    private int findString(String[] words, String s, int l, int r, Random random) {
        while (l <= r) {
            int mid = (l + r) >>> 1;
            String value = words[mid];
            
            if (value.equals("")) {
                boolean leftFirst = random.nextBoolean();
                if (leftFirst) {
                    int leftRet = findString(words, s, l, mid - 1, random);
                    if (leftRet != -1) {
                        return leftRet;
                    } else {
                        return findString(words, s, mid + 1, r, random);
                    }
                } else {
                    int rightRet = findString(words, s, mid + 1, r, random);
                    if (rightRet != -1) {
                        return rightRet;
                    } else {
                        return findString(words, s, l, mid - 1, random);
                    }
                }
            }

            int ret = value.compareTo(s);
            if (ret == 0) {
                return mid;
            } else if (ret > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
