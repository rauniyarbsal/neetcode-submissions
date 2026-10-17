class TimeMap {

    Map<String, List<Pair>> mp;
    
    static class Pair{
        String value;
        int timestamp;

        Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;

        }

    }

    public TimeMap() {
            mp = new HashMap<>();

    }
    
    public void set(String key, String value, int timestamp) {
        mp.computeIfAbsent(key, k-> new ArrayList<>()).add(new Pair(value, timestamp));
        
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key)) return "";

        List<Pair> list = mp.get(key);

        int bestIdx = binarySearch(list, timestamp);


        return (bestIdx == -1) ? "": list.get(bestIdx).value;
        
    }

    public int binarySearch(List<Pair> list, int timestamp){
        int lo = 0, hi = list.size()-1;
        int ans = -1;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;

            if(list.get(mid).timestamp <= timestamp){
                ans = mid;
                lo = mid + 1;

            }else{
                hi = mid - 1;

            }

        }


        return ans;
    }
}
