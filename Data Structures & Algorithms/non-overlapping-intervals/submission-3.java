class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a,b)->Integer.compare(a[1], b[1]));

        int count = 1, prevEnd = intervals[0][1];

        for(int []interval: intervals){

            if(interval[0] >= prevEnd){
                count++;
                prevEnd = interval[1];

            }

        }
        

        return intervals.length - count;
        
    }
}
