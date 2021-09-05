class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        var n = matrix.size
        for (i in 0 until (n + 1).shr(1)) {
            for (j in 0 until n.shr(1)) {
                val tmp = matrix[i][j]
                matrix[i][j] = matrix[n - 1 - j][i]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]
                matrix[j][n - 1 - i] = tmp
            }
        }
    }
}