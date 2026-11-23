class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(b[2], a[2])

        );

        int calculateDist = 0;
        int idx = 0;

        for(int []point: points){
            int x = point[0];
            int y = point[1];

            calculateDist = (x * x + y * y); // euclidean dist

            maxHeap.offer(new int[]{x, y, calculateDist});

            if(maxHeap.size() > k) maxHeap.poll(); // remove farthest

            idx++;
        }

        int [][]ans = new int[k][2];
        int i = 0;

        while(!maxHeap.isEmpty()){
            int []curr = maxHeap.poll();

            ans[i][0] = (int)curr[0];
            ans[i][1] = (int)curr[1];

            i++;

        }

        return ans;

    }
}
