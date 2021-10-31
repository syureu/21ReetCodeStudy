class Solution {
    var i = 0
    fun decodeString(s: String): String {
        val sb = StringBuilder()

        while (i < s.length && s[i] != ']') {
            if (s[i] !in '0'..'9') sb.append(s[i++])
            else {
                val numSt = i
                var numEd = i + 1
                while (++i < s.length && s[i] in '0'..'9') numEd++
                val num = s.substring(numSt, numEd).toInt()
                i++
                val ret = decodeString(s)
                for (j in 0 until num) sb.append(ret)
                i++
            }
        }
        return sb.toString()
    }
}