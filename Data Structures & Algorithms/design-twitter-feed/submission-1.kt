class Twitter {
    val heap = PriorityQueue<Triple<Int,Int,Int>> {a,b -> b.first - a.first }
    val userFollowMap = mutableMapOf<Int, MutableSet<Int>>()
    var timeStamp = 0

    fun postTweet(userId: Int, tweetId: Int) {
        heap.add(Triple(timeStamp++, tweetId, userId))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val userIdsToFetch = (userFollowMap[userId] ?: mutableSetOf()) + setOf(userId)
        val poppedIds = mutableListOf<Triple<Int, Int,Int>>()
        val result = mutableListOf<Int>()
        while (result.size < 10 && heap.isNotEmpty()) {
            val top = heap.poll()
            if (top.third in userIdsToFetch) {
                result.add(top.second)
            }
            poppedIds.add(top)
        }
        heap.addAll(poppedIds)
        return result.toList()
    }

    fun follow(followerId: Int, followeeId: Int) {
        userFollowMap.getOrPut(followerId) {mutableSetOf()}.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        userFollowMap[followerId]?.remove(followeeId)
    }
}
