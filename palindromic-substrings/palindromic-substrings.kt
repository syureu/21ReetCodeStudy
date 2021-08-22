class Solution {
    fun countSubstrings(s: String): Int {
        val dp = Array<BooleanArray>(s.length) { BooleanArray(s.length) }
        for (i in s.indices) dp[i][i] = true
        for (i in s.length - 2 downTo 0) for (j in i + 1 until s.length) if (s[i] == s[j]) if ((i + 1 == j) || (dp[i + 1][j - 1])) dp[i][j] = true
        var ans = 0
        for (i in s.indices) for (j in s.indices) if (dp[i][j]) ans++
        return ans
    }
}