class Solution {
    fun singleNumber(nums: IntArray): Int {
        return nums.reduce { a, v -> a.xor(v) }
    }
}