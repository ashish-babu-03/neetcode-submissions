class TimeMap() {
    val map = HashMap<String,MutableList<Pair<Int, String>>>()
    fun set(key: String, value: String, timestamp: Int) {
        map.getOrPut(key) {mutableListOf<Pair<Int,String>>()}.add(Pair(timestamp, value))
    }

    fun get(key: String, timestamp: Int): String {
        val valueList = map[key] ?: return ""
        var l = 0
        var r = valueList.size - 1
        var result = ""
        while (l <= r) {
            val mid = (l+r)/2
            val ts = valueList[mid].first
            if (ts == timestamp) return valueList[mid].second
            else if (ts < timestamp) {
                result = valueList[mid].second
                l = mid+1
            } else {
                r = mid - 1
            }
        }
        return result
    }
}
