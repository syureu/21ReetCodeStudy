class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val hash = HashMap<String, ArrayList<String>>()
        strs.forEach {
            val sorted = it.toCharArray().sorted().toString()
            if (hash[sorted] == null) hash[sorted] = ArrayList()
            hash[sorted]!!.add(it)
        }
        val ans = ArrayList<ArrayList<String>>()
        hash.forEach { (k, v) ->
            ans.add(v)
        }
        return ans
    }
}