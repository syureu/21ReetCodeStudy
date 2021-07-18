class Solution {
    fun countBits(n: Int): IntArray {
        val ret = IntArray(n + 1)
        var before = 1
        for (i in 1..n) {
            if (i.and(1) == 1) {
                ret[i] = ret[i - 1] + 1
            } else {
                ret[i] = ret[i - before++]
            }
        }
        return ret
    }
}
