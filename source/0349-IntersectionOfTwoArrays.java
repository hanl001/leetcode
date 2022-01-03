class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        Set<Integer> retSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                retSet.add(nums2[i]);
            }
        }
        int[] ret = new int[retSet.size()];
        int k = 0;
        for (int value : retSet) {
            ret[k++] = value;
        }
        return ret;
    }
}
