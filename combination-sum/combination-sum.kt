import java.util.*

class Solution {
    fun combinationSum(candidates: IntArray, target: Int, depth: Int = 0, tmp:LinkedList<Int> = LinkedList(), sum: Int = 0,ans: ArrayList<List<Int>> = ArrayList()): List<List<Int>> {
        if (depth >= candidates.size) {
            if (sum == target) {
                ans.add(tmp.toList())
            }
            return ans
        }
        if (sum + candidates[depth] <= target) {
            tmp.add(candidates[depth])
            combinationSum(candidates, target, depth, tmp, sum+candidates[depth], ans)
            tmp.removeLast()
        }
        combinationSum(candidates, target, depth+1, tmp, sum, ans)
        return ans
    }
}