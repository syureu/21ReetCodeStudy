import kotlin.math.min

class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val dp = Array(grid.size) { IntArray(grid[0].size) }
        for (i in dp.indices) {
            for (j in dp[0].indices) {
                if (i == 0) {
                    if (j == 0) dp[i][j] = grid[i][j]
                    else dp[i][j] = dp[i][j - 1] + grid[i][j]
                } else {
                    if (j == 0) dp[i][j] = dp[i - 1][j] + grid[i][j]
                    else dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
                }
                print("${dp[i][j]} ")
            }
            println()
        }

        return dp[grid.size - 1][grid[0].size - 1]
    }
}

fun main() {
    var input = Array(3) { IntArray(3) }
    input[0][0] = 1
    input[0][1] = 3
    input[0][2] = 1

    input[1][0] = 1
    input[1][1] = 5
    input[1][2] = 1

    input[2][0] = 4
    input[2][1] = 2
    input[2][2] = 1
    print(Solution().minPathSum(input))
}
