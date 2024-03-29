class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0) {
            return;
        }

        while (n > 0 && m > 0) {
            if (nums2[n - 1] > nums1[m - 1]) {
                nums1[m + n - 1] = nums2[n - 1];
                --n;
            } else {
                nums1[m + n - 1] = nums1[m - 1];
                --m;
            }
        }
        for (int i = n - 1; i >=0; --i) {
            nums1[i] = nums2[i];
        }
    }
}
