class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        while (n > 0 && m > 0) {
            if (A[m - 1] >= B[n - 1]) {
                A[m + n - 1] = A[--m];
            } else {
                A[m + n - 1] = B[--n];
            }
        }
        while (n > 0) {
            A[m + n - 1] = B[--n];
        }
    }
}
