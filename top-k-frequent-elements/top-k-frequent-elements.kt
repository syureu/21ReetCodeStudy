class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val cnt = HashMap<Int, Int>()
        for (num in nums) {
            if (cnt[num] == null) cnt[num] = 0
            cnt[num] = cnt[num]!! + 1
        }
        val arr = IntArray(cnt.size)
        var i = 0
        for ((k, v) in cnt) arr[i++] = -v
        val kth = -kthSmallest(arr, 0, arr.size - 1, k)
        i = 0
        val ans = IntArray(k)
        for ((k, v) in cnt) {
            if (kth <= v) {
                ans[i] = k
                i++
            }
        }
        return ans
    }

    fun findMedian(
        arr: IntArray,
        i: Int,
        n: Int
    ): Int {
        arr.sort(i, i + n)
        return arr[(i + i + n) / 2]
    }

    fun partition(
        arr: IntArray,
        l: Int,
        r: Int,
        x: Int
    ): Int {
        var i = l
        while (i < r) {
            if (arr[i] == x) break
            i++
        }
        swap(arr, i, r)
        i = l
        for (j in l until r) {
            if (arr[j] <= x) {
                swap(arr, i, j)
                i++
            }
        }
        swap(arr, i, r)
        return i
    }

    fun swap(
        arr: IntArray,
        i: Int,
        j: Int
    ) {
        var tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

    fun kthSmallest(
        arr: IntArray,
        l: Int,
        r: Int,
        k: Int
    ): Int {
        if (0 < k && k <= r - l + 1) {
            var n = r - l + 1
            var i = 0
            var median = IntArray((n + 4) / 5)
            while (i < n / 5) {
                median[i] = findMedian(arr, l + i * 5, 5)
                i++
            }
            if (i * 5 < n) {
                median[i] = findMedian(arr, l + i * 5, n % 5)
                i++
            }
            var medianOfMedians = if (i == 1) median[i - 1] else kthSmallest(median, 0, i - 1, i / 2)
            var pos = partition(arr, l, r, medianOfMedians)
            if (pos - l == k - 1) return arr[pos]
            if (pos - l > k - 1) return kthSmallest(arr, l, pos - 1, k)
            return kthSmallest(arr, pos + 1, r, k - (pos - l + 1))
        }
        return Int.MAX_VALUE
    }
}
