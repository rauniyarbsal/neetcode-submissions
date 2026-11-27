class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1, prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) { // non-overlapping
                count++;
                prevEnd = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}
/*
    So the greedy rule is:
Among available intervals, keep the one that ends earliest because it leaves the most room for
subsequent intervals.
*/