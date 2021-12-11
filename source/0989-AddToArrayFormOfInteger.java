class Solution {
    // Input: num = [1,2,0,0], k = 34
    // Output: [1,2,3,4]
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int i = num.length - 1;
        while (k != 0 && i >= 0) {
            int cur = k % 10;
            int sum = cur + num[i--];
            list.addFirst(sum % 10);
            k /= 10;
            k += sum / 10;
        }

        if (i < 0) {
            while (k != 0) {
                list.addFirst(k % 10);
                k /= 10;
            }
        } else {
            while (i >= 0) {
                list.addFirst(num[i--]);
            }
        }

        return list;
    }
}
