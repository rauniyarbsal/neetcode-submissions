class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;

        ArrayList<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals, (a,b)->Integer.compare(a[1], b[1]));

        for(int []interval: intervals){
            if(ans.isEmpty() || interval[0] >= ans.get(ans.size()-1)[1]){
                ans.add(interval);

            }

        }
        

        return intervals.length - ans.size();
        
    }
}
