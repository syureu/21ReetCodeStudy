class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var writer = 0
        for (reader in nums.indices) {
            if (nums[reader] != 0) {
                nums[writer++] = nums[reader]
            }
        }
        while (writer < nums.size) {
            nums[writer++] = 0
        }
    }
}