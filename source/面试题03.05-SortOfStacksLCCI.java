class SortedStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> dummyStack = new Stack<>();

    public SortedStack() {

    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }
        while (!stack.isEmpty() && val > stack.peek()) {
            dummyStack.push(stack.pop());
        }
        stack.push(val);
        while (!dummyStack.isEmpty()) {
            stack.push(dummyStack.pop());
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
    }
    
    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */
