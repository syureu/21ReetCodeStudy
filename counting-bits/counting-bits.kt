class Solution {
    fun countBits(n: Int): IntArray {
        val ret = IntArray(n + 1)
        for (i in 0..n) {
            ret[i] = i.toString(2).filter { c -> c == '1' }.length
        }
        return ret
    }
}