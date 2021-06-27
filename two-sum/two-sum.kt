class Solution {
    val hash = HashMap<Int, Int>()
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for ((i, v) in nums.withIndex()) {
            if (hash[target - v] == null) hash[v] = i else return intArrayOf(hash[target - v]!!, i)
        }
        return intArrayOf()
    }
}