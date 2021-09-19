class Solution {
    fun findDuplicate(nums: IntArray): Int {
        val hash = HashSet<Int>()
        for (i in nums) {
            if (hash.contains(i)) return i
            hash.add(i)
        }
        throw AssertionError()
    }
}