import java.util.*

class MedianFinder() {
    val pq1 = PriorityQueue<Int> { o1, o2 -> o2.compareTo(o1) }
    val pq2 = PriorityQueue<Int>()
    var pq1Offer = false
    var count = 0

    fun addNum(num: Int) {
        when (pq1Offer) {
            false -> {
                pq2.offer(num)
                pq1.offer(pq2.poll())
            }
            true -> {
                pq1.offer(num)
                pq2.offer(pq1.poll())
            }
        }
        pq1Offer = !pq1Offer
        count++
    }

    fun findMedian(): Double {
        return when (count.and(1)) {
            0 -> (pq1.peek().toDouble() + pq2.peek()) / 2
            else -> pq1.peek().toDouble()
        }
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */