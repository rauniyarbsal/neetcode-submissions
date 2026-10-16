class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();

        int i = 0;

        // insert pairs which comes before newInterval
        while(i < intervals.length && (intervals[i][1] < newInterval[0])){
            ans.add(intervals[i]);

            i++;
        }

        // Merge all pair that overlaps with newInterval
        while(i < intervals.length && (intervals[i][0] <= newInterval[1])){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        // Add the final merged/new interval
        ans.add(newInterval);

        // Add everything completely AFTER newInterval
        while (i < intervals.length) {
            ans.add(intervals[i]);
            i++;
        }


        return ans.toArray(new int[ans.size()][]);

    }
}
