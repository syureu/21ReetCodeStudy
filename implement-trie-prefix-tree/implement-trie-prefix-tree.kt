class Trie() {
    val hash = HashMap<Char, Trie>()
    var isWord = false

    fun insert(word: String, pt: Int = 0) {
        if (word.length == pt) {
            isWord = true
            return
        }
        if (hash[word[pt]] == null) hash[word[pt]] = Trie()
        hash[word[pt]]!!.insert(word, pt + 1)
    }

    fun search(word: String, pt: Int = 0): Boolean {
        if (word.length == pt) {
            return isWord
        }
        if (hash[word[pt]] == null) return false
        return hash[word[pt]]!!.search(word, pt + 1)
    }

    fun startsWith(prefix: String, pt: Int = 0): Boolean {
        if (prefix.length == pt) {
            return true
        }
        if (hash[prefix[pt]] == null) return false
        return hash[prefix[pt]]!!.startsWith(prefix, pt + 1)
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */