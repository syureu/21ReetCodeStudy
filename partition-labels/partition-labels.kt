class Solution {
    fun partitionLabels(s: String): List<Int> {
        val hash = HashMap<Char, Pair<Int, Int>>()
        val ans = ArrayList<Int>()
        s.forEachIndexed { index, c ->
            if (hash[c] == null) hash[c] = Pair(index, index) else hash[c] = Pair(hash[c]!!.first, index)
        }
        var prevCut = -1
        var cut = 0
        for (i in s.indices) {
            cut = cut.coerceAtLeast(hash[s[i]]!!.second)
            if (i == hash[s[cut]]!!.second) {
                ans.add(cut - prevCut)
                prevCut = cut
            }
        }
        return ans
    }
}

fun main() {
    Solution().partitionLabels("ababcbacadefegdehijhklij").forEach { print("$it ") }
    println()
    Solution().partitionLabels("eccbbbbdec").forEach { print("$it ") }
    println()
}