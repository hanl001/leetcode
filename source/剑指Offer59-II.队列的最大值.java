class MaxQueue {

    private Deque<Integer> deque = new LinkedList<>();
    private Queue<Integer> queue = new LinkedList<>();

    public MaxQueue() {

    }
    
    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }
    
    public void push_back(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }

        queue.offer(value);
        deque.offerLast(value);
    }
    
    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int value = queue.poll();
        if (value == deque.peekFirst()) {
            deque.pollFirst();
        }
        return value;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
