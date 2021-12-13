public class Solution {
    /**
     * @param expression: a list of strings
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        // write your code here
        Stack<Integer> nums = new Stack<>();
        Stack<String> ops = new Stack<>();
        int i = 0;
        while (i < expression.length) {
            String cur = expression[i++];
            if (cur.equals("(")) {
                ops.push(cur);
            } else if (cur.equals(")")) {
                while (!ops.peek().equals("(")) {
                    String op = ops.pop();
                    int toNum = nums.pop();
                    int fromNum = nums.pop();
                    if (op.equals("+")) {
                        int ret = fromNum + toNum;
                        nums.push(ret);
                    } else if (op.equals("-")) {
                        int ret = fromNum - toNum;
                        nums.push(ret);
                    } else if (op.equals("*")) {
                        int ret = fromNum * toNum;
                        nums.push(ret);
                    } else {
                        int ret = fromNum / toNum;
                        nums.push(ret);
                    }
                }
                ops.pop();
            } else if (cur.equals("*") || cur.equals("/")) {
                while (!ops.isEmpty() && !ops.peek().equals("(") && !ops.peek().equals("+") && !ops.peek().equals("-")) {
                    String latestOp = ops.pop();
                    int toNum = nums.pop();
                    int fromNum = nums.pop();
                    if (latestOp.equals("*")) {
                        int ret = fromNum * toNum;
                        nums.push(ret);
                    } else {
                        int ret = fromNum / toNum;
                        nums.push(ret);
                    }
                }
                ops.push(cur);
            } else if (cur.equals("+") || cur.equals("-")) {
                while (!ops.isEmpty() && !ops.peek().equals("(")) {
                    String latestOp = ops.pop();
                    int toNum = nums.pop();
                    int fromNum = nums.pop();
                    if (latestOp.equals("+")) {
                        int ret = fromNum + toNum;
                        nums.push(ret);
                    } else if (latestOp.equals("-")) {
                        int ret = fromNum - toNum;
                        nums.push(ret);
                    } else if (latestOp.equals("*")) {
                        int ret = fromNum * toNum;
                        nums.push(ret);
                    } else {
                        int ret = fromNum / toNum;
                        nums.push(ret);
                    }
                }
                ops.push(cur);
            } else {
                int num = Integer.parseInt(cur);
                nums.push(num);
            }
        }

        while (!ops.isEmpty()) {
            String op = ops.pop();
            int toNum = nums.pop();
            int fromNum = nums.pop();
            if (op.equals("+")) {
                int ret = fromNum + toNum;
                nums.push(ret);
            } else if (op.equals("-")) {
                int ret = fromNum - toNum;
                nums.push(ret);
            } else if (op.equals("*")) {
                int ret = fromNum * toNum;
                nums.push(ret);
            } else {
                int ret = fromNum / toNum;
                nums.push(ret);
            }
        }
        if (nums.isEmpty()) {
            return 0;
        }
        return nums.pop();
    }
}

