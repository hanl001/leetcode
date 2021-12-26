class Solution {
    public int[] smallestK(int[] arr, int k) {
        return smallestK(arr, 0, arr.length - 1, k - 1);
    }

    private int[] smallestK(int[] arr, int left, int right, int index) {
        while (left < right) {
            int curIndex = partition(arr, left, right);
            if (curIndex > index) {
                right = curIndex - 1;
            } else if (curIndex < index) {
                left = curIndex + 1;
            } else {
                break;
            }
        }
        return Arrays.copyOf(arr, index + 1);
    }

    private int partition(int[] arr, int left, int right) {
        int value = arr[right];
        while (left < right) {
            while (left < right && arr[left] <= value) {
                left++;
            }
            if (left < right) {
                arr[right--] = arr[left];
            }
            while (left < right && arr[right] > value) {
                right--;
            }
            if (left < right) {
                arr[left++] = arr[right];
            }
        }
        arr[left] = value;
        return left;
    }
}
