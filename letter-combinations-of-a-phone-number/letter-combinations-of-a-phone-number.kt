class Solution() {
    private val ans = ArrayList<String>()
    private val hash = HashMap<Char, CharArray>()
    lateinit var input: String

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return ArrayList()
        input = digits

        hash['2'] = charArrayOf('a', 'b', 'c')
        hash['3'] = charArrayOf('d', 'e', 'f')
        hash['4'] = charArrayOf('g', 'h', 'i')
        hash['5'] = charArrayOf('j', 'k', 'l')
        hash['6'] = charArrayOf('m', 'n', 'o')
        hash['7'] = charArrayOf('p', 'q', 'r', 's')
        hash['8'] = charArrayOf('t', 'u', 'v')
        hash['9'] = charArrayOf('w', 'x', 'y', 'z')

        recursive(0, "")

        return ans
    }

    private fun recursive(depth: Int, builder: String) {
        if (depth >= input.length) {
            ans.add(builder)
            return
        }
        for (i in hash[input[depth]]!!) {
            recursive(depth + 1, builder + i)
        }
    }
}