class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length < groupSize) return false;

        if(hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> freqMap = new TreeMap<>();

        for(int num: hand) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        while(freqMap.size() > 0){
            int start = freqMap.firstKey();

            for(int i =0; i < groupSize; i++){
                int card = start + i;

                if(freqMap.containsKey(card)) {
                    freqMap.put(card, freqMap.get(card) - 1);

                    if(freqMap.get(card) <= 0) freqMap.remove(card);


                }
                else return false;


            }
        }

        return true;
        
    }
}
