class LRUCache(capacity: Int) {
    val head = Node(0, 0)
    val tail = Node(0, 0)
    val hashMap = mutableMapOf<Int, Node?>()
    val cap = capacity
    init {
        head.next = tail
        tail.prev = head
    }
    fun get(key: Int): Int {
        if (!hashMap.containsKey(key)) return -1
        val node = hashMap[key]!!
            removeNode(node)
            addNode(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (hashMap.containsKey(key)) {
            val node = hashMap[key]!!
            node.value = value
            removeNode(node)
            addNode(node)
        } else {
            if (hashMap.size == cap) {
                val lru = tail!!.prev!!
                removeNode(lru)
                hashMap.remove(lru.key)
            }
                val node =Node(key,value)
                addNode(node)
                hashMap[key] = node
            
        }

    }
    

    fun addNode(node: Node) {
        var next = head!!.next
        next!!.prev = node
        node!!.next = next
        node!!.prev = head
        head!!.next = node
        
    }
    fun removeNode(node: Node) {
        node.prev!!.next = node.next
        node.next!!.prev = node.prev
    }
}
 class Node(var key: Int, var value: Int) {
    var next: Node? = null
    var prev: Node? = null
 }