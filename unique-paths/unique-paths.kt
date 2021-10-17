class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val min = m.coerceAtMost(n)
        val N = m + n - 2
        var ans = 1L
        if (min != 1) {
            var div = 1
            for (i in N - min + 2..N) {
                ans *= i;
                if (ans % div == 0L) {
                    ans /= div++
                }
            }
            for (i in div until min) ans /= i
        }
        return ans.toInt()
    }
}