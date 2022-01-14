class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return b[0] - a[0];
                }
            }
        );
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int pow = (int)Math.pow(point[1], 2) + (int)Math.pow(point[0], 2);
            if (pq.size() == k) {
                int[] top = pq.peek();
                if (pow < top[0]) {
                    pq.poll();
                    pq.offer(new int[]{pow, i});
                }
            } else {
                pq.offer(new int[]{pow, i});
            }
        }
        int[][] result = new int[k][2];
        int i = 0;
        for (int[] item : pq) {
            result[i++] = points[item[1]];
        }
        return result;
    }
}
