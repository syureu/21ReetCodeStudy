class Solution {
    private val dp = IntArray(10001) { Int.MAX_VALUE }
    fun numSquares(n: Int): Int {
        dp[0] = 0
        recursive(0)
        return dp[n]
    }

    private fun recursive(n: Int) {
        for (i in 100 downTo 1) {
            val next = i * i + n
            if (next > 10000) continue
            if (dp[next] > dp[n] + 1) {
                dp[next] = dp[n] + 1
                recursive(next)
            }
        }
    }
}