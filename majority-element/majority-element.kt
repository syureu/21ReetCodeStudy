class Solution {
    fun majorityElement(nums: IntArray): Int {
        var tmp = nums[0]
        var tmpCount = 1
        for(i in 1 until nums.size) {
            if (tmpCount == 0) {
                tmp = nums[i]
                tmpCount = 1
            } else {
                if (tmp == nums[i]) {
                    tmpCount++
                } else {
                    tmpCount--
                }
            }
        }
        return tmp
    }
}