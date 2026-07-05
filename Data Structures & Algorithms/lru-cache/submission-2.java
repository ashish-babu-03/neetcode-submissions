class LRUCache {
    int capacity = 0;
    Node head = new Node( -1, -1), tail = new Node(-1, -1);
    Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        var node = cache.get(key);
        moveToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            var node = cache.get(key);
            node.value = value;
            updateNode(node);
        } else {
            if (cache.size() == capacity) removeLastNode();
            var node = new Node(key, value);
            addNewNode(node);
        }
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void updateNode(Node node) {
        cache.put (node.key, node);
        moveToFront(node);
    }

    private void addNewNode(Node node) {
        cache.put(node.key, node);
        addNode(node);
    }

    private void addNode(Node node) {
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void removeLastNode() {
        cache.remove(tail.prev.key);
        removeNode(tail.prev);
    }
}

class Node {
    int key;
    int value;
    Node next = null;
    Node prev = null;
    Node (int _key, int _value) {
        key = _key;
        value = _value;
    }
}