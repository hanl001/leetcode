class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // ensure nums1.length <= nums2.length
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        if (nums1.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        int[] ret = new int[nums2.length];
        int retEnd = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                ret[retEnd++] = num;
                map.put(num, count - 1);
                
            }
        }

        return Arrays.copyOfRange(ret, 0, retEnd);
    }
}
