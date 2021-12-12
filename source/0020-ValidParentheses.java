class Solution {
    public boolean isValid(String s) {
        // Stack<Character> stack = new Stack<>();
        // for (int i = 0; i < s.length(); i++) {
        //     char cur = s.charAt(i);
        //     if (stack.isEmpty()) {
        //         if (cur == ')' || cur == ']' || cur == '}') {
        //             return false;
        //         }
        //         stack.push(cur);
        //     } else {
        //         if (cur == '(' || cur == '[' || cur == '{') {
        //             stack.push(cur);
        //         } else if (cur == ')' && stack.peek() == '(') {
        //             stack.pop();
        //         } else if (cur == ']' && stack.peek() == '[') {
        //             stack.pop();
        //         } else if (cur == '}' && stack.peek() == '{') {
        //             stack.pop();
        //         } else {
        //             return false;
        //         }
        //     }
        // }
        // return stack.isEmpty();

        // 法2: 数组模拟栈
        int[] list = new int[s.length()];
        int count = -1;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                list[++count] = cur;
            } else {
                if (count == -1) {
                    return false;
                }
                int peek = list[count];
                if (cur == ')' && peek == '(') {
                    --count;
                } else if (cur == ']' && peek == '[') {
                    --count;
                } else if (cur == '}' && peek == '{') {
                    --count;
                } else {
                    return false;
                }
            }
        }
        return count == -1;
    }
}
