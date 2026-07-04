class TimeMap {

    HashMap<String, List<Pair>> timeMap = new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) return "";
        List<Pair> list = timeMap.get(key);

        int l = 0, r = list.size() - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid).timestamp <= timestamp) l = mid + 1;
            else r = mid - 1;
        }
        return (r < 0) ? "" : list.get(r).value;
    }


private static class Pair {
    String value;
    int timestamp;
    Pair(String val, int timestamp) {
        this.value = val;
        this.timestamp = timestamp;
    }
}
}
