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

        int bestIdx = -1;

        for(int i=0; i < list.size(); i++){ // linear search
            if(list.get(i).timestamp <= timestamp){
                bestIdx = i;

            }

        }


        return (bestIdx == -1) ? "": list.get(bestIdx).value;
        
    }
}
