class LRUCache(capacity: Int) {
    private val cap = capacity
    private val cacheMap = mutableMapOf<Int, Node>()
    var head: Node = Node(0, 0)
    var tail: Node = Node(0, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    class Node(var key: Int, var value: Int ) {
        var next: Node? = null
        var prev: Node? = null
    }

    fun get(key: Int): Int {
        if (!cacheMap.containsKey(key)) return -1
        val node = cacheMap[key]!!
        removeNode(node)
        addNode(node)
        return node!!.value
    }

    fun put(key: Int, value: Int) {
        
        if (cacheMap.contains(key)) {
            val node = cacheMap[key]!!
            node.value = value
            removeNode(node)
            addNode(node)
            return 
        } 
         if (cap == cacheMap.size) {
            val lru = tail.prev!!
            removeNode(lru)
            cacheMap.remove(lru.key!!)
        }
        val node = Node(key, value)
        addNode(node)
        cacheMap[key] = node
    
    }

    fun addNode(node: Node) {
        val next = head.next
        head.next = node
        node.prev = head
        node.next = next
        next?.prev = node
    }

    fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }
}
