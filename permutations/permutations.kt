class Solution {
    fun permute(nums: IntArray, ans: List<Int> = listOf(), numsCopy: List<Int> = nums.toList()): List<List<Int>> =
        if (numsCopy.size != 1) numsCopy.flatMap { v -> permute(nums, ans + v, numsCopy - v) } else listOf(ans + numsCopy)
}