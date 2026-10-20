class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i = 0;

        //1. Insert pairs which comes before new Interval into ans
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);

            i++;

        }

        //2. Merge pairs with new Interval and create new Interval
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);

            i++;
        }

        // After merging is finished
        ans.add(newInterval);

        //3. After creating new merged new Interval, now check with after pairs
        while(i < intervals.length){
            ans.add(intervals[i]);
            i++;

        }

        return ans.toArray(new int[ans.size()][]);
        
    }
}
