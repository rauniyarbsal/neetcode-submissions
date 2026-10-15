class TimeMap {
    Map<String, List<Pair>> freqMap;

    static class Pair{

        String value;
        int timestamp;

        Pair(String value, int timestamp){
            this.timestamp = timestamp;
            this.value = value;

        }

    }

    public TimeMap() {
        freqMap = new HashMap<>();

    }
    
    public void set(String key, String value, int timestamp) {
        freqMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));

    }
    
    public String get(String key, int timestamp) {
        if(!freqMap.containsKey(key)) return "";
        List<Pair> list = freqMap.get(key);

        int bestIdx = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).timestamp <= timestamp) {
                bestIdx = i;
            } else {
                break;
            }
        }

        return (bestIdx == -1) ? "" : list.get(bestIdx).value;
        
    }
}
