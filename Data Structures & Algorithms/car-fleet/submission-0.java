class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // distance = target - position[i]
        // speed 
        // compute time for each car = dist/speed
        // compare if two car time <= each other then same fleet otherwise separate

        int n = position.length;

        // Store position and speed together
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Closest to target first
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        Deque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            double time =
                (double) (target - cars[i][0]) / cars[i][1];

            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
