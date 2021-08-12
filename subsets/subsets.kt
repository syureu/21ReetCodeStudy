import java.util.*
import kotlin.collections.ArrayList

class Solution {
    fun subsets(
        nums: IntArray,
        depth: Int = 0,
        arr: LinkedList<Int> = LinkedList(),
        ans: ArrayList<List<Int>> = ArrayList()
    ): List<List<Int>> {
        if (depth == nums.size) ans.add(arr.toList()) else {
            arr.add(nums[depth])
            subsets(nums, depth + 1, arr, ans)
            arr.removeLast()
            subsets(nums, depth + 1, arr, ans)
        }
        return ans
    }
}