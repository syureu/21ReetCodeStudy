class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        return nums.sortedDescending()[k - 1]
    }
}