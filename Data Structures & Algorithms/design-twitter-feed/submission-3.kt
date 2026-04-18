class Twitter {
    val tweetMap = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    val userFollowMap = mutableMapOf<Int, MutableSet<Int>>()
    var timeStamp = 0

    fun postTweet(userId: Int, tweetId: Int) {
        tweetMap.getOrPut(userId) {mutableListOf()}.add(Pair(timeStamp++, tweetId))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val heap = PriorityQueue<Pair<Int, Int>>(compareByDescending {it.first} )
        val users = (userFollowMap[userId] ?: mutableSetOf()) + setOf(userId)
        for (user in users) {
            if (tweetMap[user] != null) heap.addAll(tweetMap[user]!!)
        }
        val result = mutableListOf<Int>()
        while(result.size <10 && heap.isNotEmpty()) {
            result.add(heap.poll().second)
        }
        return result
    }

    fun follow(followerId: Int, followeeId: Int) {
        userFollowMap.getOrPut(followerId) {mutableSetOf()}.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        userFollowMap[followerId]?.remove(followeeId)
    }
}
