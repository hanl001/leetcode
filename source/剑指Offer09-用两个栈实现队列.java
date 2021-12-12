class CQueue {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> dummyStack = new Stack<>();

    public CQueue() {

    }
    
    public void appendTail(int value) {
        stack.push(value);
    }
    
    public int deleteHead() {
        if (stack.isEmpty()) {
            return -1;
        }
        while (!stack.isEmpty()) {
            dummyStack.push(stack.pop());
        }
        int value = dummyStack.pop();
        while (!dummyStack.isEmpty()) {
            stack.push(dummyStack.pop());
        }
        return value;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
