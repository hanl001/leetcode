class Solution {
    //// 法 1: 表达式求值
    //public int calculate(String s) {
    //    Stack<Integer> nums = new Stack<>();
    //    Stack<Character> ops = new Stack<>();
    //    int i = 0;
    //    while (i < s.length()) {
    //        char ch = s.charAt(i);
    //        if (Character.isDigit(ch)) {
    //            int num = 0;
    //            while (i < s.length() && Character.isDigit(s.charAt(i))) {
    //                int cur = s.charAt(i) - '0';
    //                num = 10 * num + cur;
    //                i++;
    //            }
    //            nums.push(num);
    //        } else if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {
    //            while (!ops.isEmpty()) {
    //                int op = ops.peek();
    //                if (op == '*') {
    //                    int toNum = nums.pop();
    //                    int fromNum = nums.pop();
    //                    int ret = fromNum * toNum;
    //                    nums.push(ret);
    //                    ops.pop();
    //                } else if (op == '/') {
    //                    int toNum = nums.pop();
    //                    int fromNum = nums.pop();
    //                    int ret = fromNum / toNum;
    //                    nums.push(ret);
    //                    ops.pop();
    //                } else if (ch == '+' || ch == '-') {
    //                    if (op == '+') {
    //                        int toNum = nums.pop();
    //                        int fromNum = nums.pop();
    //                        int ret = fromNum + toNum;
    //                        nums.push(ret);
    //                        ops.pop();
    //                    } else {
    //                        int toNum = nums.pop();
    //                        int fromNum = nums.pop();
    //                        int ret = fromNum - toNum;
    //                        nums.push(ret);
    //                        ops.pop();
    //                    }
    //                } else {
    //                    break;
    //                }
    //            }
    //            ops.push(ch);
    //            i++;
    //        } else {
    //            i++;
    //        }
    //    }
    //    while (!ops.isEmpty()) {
    //        int op = ops.pop();
    //        int toNum = nums.pop();
    //        int fromNum = nums.pop();
    //        int ret = 0;
    //        if (op == '*') {
    //            ret = fromNum * toNum;
    //        } else if (op == '/') {
    //            ret = fromNum / toNum;
    //        } else if (op == '+') {
    //            ret = fromNum + toNum;
    //        } else {
    //            ret = fromNum - toNum;
    //        }
    //        nums.push(ret);
    //    }
    //    return nums.pop();
    //}

    //法2: 优先计算乘除
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        int i = 0;
        int latestOp = '+';
        while (i < s.length()) {
            char ch = s.charAt(i);
            i++;
            if (ch == ' ') {
                continue;
            }

            if (Character.isDigit(ch)) {
                int num = ch - '0';
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    int cur = s.charAt(i) - '0';
                    num = 10 * num + cur;
                    i++;
                }
                if (latestOp == '+') {
                    nums.push(num);
                } else if (latestOp == '-') {
                    nums.push(-num);
                } else if (latestOp == '*') {
                    nums.push(nums.pop() * num);
                } else {
                    nums.push(nums.pop() / num);
                }
            } else {
                latestOp = ch;
            }
        }

        int ret = 0;
        while (!nums.isEmpty()) {
            ret += nums.pop();
        }
        return ret;
    }
}
