class MedianFinder {

    public MedianFinder() {

    }
    
    PriorityQueue<Integer> minPq = new PriorityQueue<>(); // 小顶堆
    PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a); // 大顶堆
    public void addNum(int num) {
        if (minPq.size() < maxPq.size()) {
            if (num < maxPq.peek()) {
                minPq.offer(maxPq.poll());
                maxPq.offer(num);
            } else {
                minPq.offer(num);
            }
        } else {
            if (maxPq.size() == 0) {
                maxPq.offer(num);
            } else {
                if (num > minPq.peek()) {
                    maxPq.offer(minPq.poll());
                    minPq.offer(num);
                } else {
                    maxPq.offer(num);
                }
            }
        }
    }
    
    public double findMedian() {
        if (minPq.size() < maxPq.size()) {
            return maxPq.peek();
        } else {
            int min = minPq.peek();
            int max = maxPq.peek();
            return (double)(min + max) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
