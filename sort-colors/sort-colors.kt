class Solution {
    fun sortColors(nums: IntArray): Unit {
        val hash = HashMap<Int, Int>()
        hash[0] = 0
        hash[1] = 0
        hash[2] = 0
        nums.forEach {
            hash[it] = hash[it]!! + 1
        }
        for (i in 0 until hash[0]!!) {
            nums[i] = 0
        }
        for (i in hash[0]!! until hash[0]!! + hash[1]!!) {
            nums[i] = 1
        }
        for (i in hash[0]!! + hash[1]!! until nums.size) {
            nums[i] = 2
        }
    }
}