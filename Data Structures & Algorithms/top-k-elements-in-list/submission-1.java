class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int x: nums){
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }

        List<List<Integer>> bucketSort = new ArrayList<>();

        for(int i=0; i <= nums.length; i++){
            bucketSort.add(new ArrayList<>());
        }

        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            bucketSort.get(freq).add(key);
        }

        int []answer = new int[k];
        int idx = 0;

        for(int i=bucketSort.size()-1; i >= 0 && idx < k; i--){
            for(int val : bucketSort.get(i)){
                answer[idx++] = val;
                if (idx == k) {
                    break;
                }
            }


        }

        return answer;

        
    }
}
