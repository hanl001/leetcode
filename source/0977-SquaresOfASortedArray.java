/*
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].

Example 2:
    Input: nums = [-7,-3,2,3,11]
    Output: [4,9,9,49,121]
 

Constraints:
    1 <= nums.length <= 10^4
    -10^4 <= nums[i] <= 10^4
    nums is sorted in non-decreasing order.
 

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int start = 0, end = nums.length - 1, resultEnd = nums.length - 1;
        int startValue = nums[start] * nums[start];
        int endValue = nums[end] * nums[end];
        while (start <= end) {
            if (startValue > endValue) {
                result[resultEnd--] = startValue;
                start++;
                if (start <= end) {
                    startValue = nums[start] * nums[start];
                }
            } else {
                result[resultEnd--] = endValue;
                end--;
                if (start <= end) {
                    endValue = nums[end] * nums[end];
                }
            }
        }
        return result;
    }
}
