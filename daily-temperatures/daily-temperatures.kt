import java.util.*

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val st = Stack<Temp>()
        val ans = IntArray(temperatures.size)
        temperatures.forEachIndexed { index, v ->
            while (st.isNotEmpty() && st.peek().temp < v) {
                var poped = st.pop()
                ans[poped.index] = index - poped.index
            }
            st.push(Temp(v, index))
        }
        return ans
    }
}

class Temp(val temp: Int, val index: Int)