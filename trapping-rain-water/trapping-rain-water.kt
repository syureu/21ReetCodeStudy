import kotlin.math.*

class Solution {
    fun trap(height: IntArray): Int {
        val left = IntArray(height.size)
        val right = IntArray(height.size)
        val min = IntArray(height.size)
        for (i in height.indices) {
            if (i != 0) {
                left[i] = max(height[i], left[i - 1])
            } else {
                left[i] = height[i]
            }
        }
        for (i in height.size - 1 downTo 0) {
            if (i != height.size - 1) {
                right[i] = max(height[i], right[i + 1])
            } else {
                right[i] = height[i]
            }
            min[i] = min(left[i], right[i])
        }
        var ans = 0
        for (i in height.indices) {
            if (min[i] - height[i] > 0) {
                ans += min[i] - height[i]
            }
        }
        return ans
    }
}