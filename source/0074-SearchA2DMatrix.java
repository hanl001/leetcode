πclass Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int i = mid / n;
            int j = mid % n;
            int value = matrix[i][j];
            if (value == target) {
                return true;
            } else if (value < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
