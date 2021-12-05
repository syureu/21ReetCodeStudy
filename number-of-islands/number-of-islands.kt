class Solution {
    lateinit var map: Array<CharArray>
    lateinit var visit: Array<BooleanArray>
    var ans = 0
    fun numIslands(grid: Array<CharArray>): Int {
        map = grid
        visit = Array(grid.size) { BooleanArray(grid[0].size) }
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (!visit[i][j] && map[i][j] == '1') {
                    ans++
                    dfs(i, j)
                }
            }
        }
        return ans
    }

    private fun dfs(i: Int, j: Int) {
        visit[i][j] = true
        for (k in 0..3) {
            val di = i + "0121"[k].toInt() - '1'.toInt()
            val dj = j + "1210"[k].toInt() - '1'.toInt()
            if (0 <= di && di < map.size && 0 <= dj && dj < map[0].size) {
                if (!visit[di][dj] && map[di][dj] == '1') {
                    dfs(di, dj)
                }
            }
        }
    }
}