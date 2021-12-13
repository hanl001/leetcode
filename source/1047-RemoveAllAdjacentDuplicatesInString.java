class Solution {
    //// 法 1
    //public String removeDuplicates(String s) {
    //    Stack<Character> stack = new Stack<>();
    //    for (int i = 0; i < s.length(); i++) {
    //        if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
    //            stack.push(s.charAt(i));
    //        } else {
    //            while (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
    //                stack.pop();
    //            }
    //        }
    //    }
    //    StringBuilder sb = new StringBuilder();
    //    while (!stack.isEmpty()) {
    //        char ch = stack.pop();
    //        sb.insert(0, ch);
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
