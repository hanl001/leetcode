class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> set2 = new HashSet<>();
        for (int v : arr2) {
            set2.add(v);
        }
        Map<Integer, Integer> v1Count = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int v : arr1) {
            if (set2.contains(v)) {
                int count = v1Count.getOrDefault(v, 0);
                v1Count.put(v, count + 1);
            } else {
                list.add(v);
            }
        }
        int[] ret = new int[arr1.length];
        int k = 0;
        for (int v : arr2) {
            int count = v1Count.getOrDefault(v, 0);
            while (count > 0) {
                ret[k++] = v;
                count--;
            }
        }
        list.sort(Comparator.naturalOrder());
        for (int v : list) {
            ret[k++] = v;
        }
        return ret;
    }
}
