class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }

        int[] ret = new int[nums.length - k + 1];
        ret[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }

            // enque and deque
            deque.offerLast(nums[i]);
            if (nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }

            ret[i - k + 1] = deque.peekFirst();
        }
        return ret;
    }
}
