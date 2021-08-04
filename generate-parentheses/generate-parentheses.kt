class Solution {
    fun generateParenthesis(n: Int, open: Int = 0, close: Int = 0, str: String = "", ret: ArrayList<String> = ArrayList()): List<String> {
        if (str.length == n * 2) {
            ret.add(str)
            return ret
        }
        if (open > 0 && open > close) {
            generateParenthesis(n, open, close + 1, "$str)", ret)
        }
        if (open < n) {
            generateParenthesis(n, open + 1, close, "$str(", ret)
        }
        return ret
    }
}