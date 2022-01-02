class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        var ans = dp[0]
        for (i in 1 until nums.size) {
            dp[i] = if (nums[i] > nums[i] + dp[i - 1]) nums[i] else nums[i] + dp[i - 1]
            ans = ans.coerceAtLeast(dp[i])
        }
        return ans
    }
}