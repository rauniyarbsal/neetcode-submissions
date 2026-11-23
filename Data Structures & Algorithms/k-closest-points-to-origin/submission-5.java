class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(
            (a,b) -> Double.compare(b[2], a[2])

        );

        double calculateDist = 0;
        int idx = 0;

        for(int []point: points){
            int x = point[0];
            int y = point[1];

            calculateDist = (double)(x * x + y * y); // euclidean dist

            maxHeap.offer(new double[]{x, y, calculateDist});

            if(maxHeap.size() > k) maxHeap.poll(); // remove farthest

            idx++;
        }

        int [][]ans = new int[k][2];
        int i = 0;

        while(!maxHeap.isEmpty()){
            double []curr = maxHeap.poll();

            ans[i][0] = (int)curr[0];
            ans[i][1] = (int)curr[1];

            i++;

        }

        return ans;

    }
}
