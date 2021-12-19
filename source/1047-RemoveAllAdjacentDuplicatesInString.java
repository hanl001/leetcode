class Solution {
    //// 法 1
    //public String removeDuplicates(String s) {
    //    Deque<Character> deque = new LinkedList<>();
    //    for (int i = 0; i < s.length(); i++) {
    //        if (deque.isEmpty() || deque.peekLast() != s.charAt(i)) {
    //            deque.offerLast(s.charAt(i));
    //        } else {
    //            while (!deque.isEmpty() && deque.peekLast() == s.charAt(i)) {
    //                deque.pollLast();
    //            }
    //        }
    //    }
    //    StringBuilder sb = new StringBuilder();
    //    while (!deque.isEmpty()) {
    //        char ch = deque.pollFirst();
    //        sb.append(ch);
    //    }
    //    return sb.toString();
    //}

    // 法 2
    public String removeDuplicates(String s) {
        char[] array = s.toCharArray();
        int i = 0; // 模拟栈
        // "abbaca"
        for (int j = 1; j < array.length; j++) {
            if (i == -1 || array[j] != array[i]) {
                array[++i] = array[j];
            } else {
                while (i > -1 && array[i] == array[j]) {
                    --i;
                }
            }
        }
        return new String(array, 0, i + 1);
    }
}
