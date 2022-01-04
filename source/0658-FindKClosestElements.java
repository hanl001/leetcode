class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        List<Integer> list = new ArrayList<>();
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int value = arr[mid];
            if (value >= x) {
                if (mid == 0) {
                    while (k > 0) {
                        list.add(arr[mid++]);
                        k--;
                    }
                    break;
                } else if (arr[mid - 1] < x) {
                    int midL = mid - 1, midR = mid;
                    while (k > 0) {
                        if (midR == arr.length || (midL >= 0 && arr[midR] - x >= x - arr[midL])) {
                            midL--;
                        } else {
                            midR++;
                        }
                        k--;
                    }
                    for (int i = midL + 1; i < midR; i++) {
                        list.add(arr[i]);
                    }
                    break;
                } else {
                    r = mid - 1;
                }
            } else {
                 if (mid == arr.length - 1) {
                    for (int i = mid - k + 1; i <= mid; i++) {
                        list.add(arr[i]);
                    }
                    break;
                }
                l = mid + 1;
            }
        }
        return list;
    }
}
