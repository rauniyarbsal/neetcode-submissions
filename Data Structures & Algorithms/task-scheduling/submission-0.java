class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char ch : tasks) freq[ch - 'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int count : freq) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;

            // FIRST: release anything available at this time
            if (!cooldown.isEmpty() && cooldown.peek()[1] <= time) {
                int[] ready = cooldown.poll();
                maxHeap.offer(ready[0]);
            }

            // THEN execute
            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll() - 1;

                if (count > 0) {
                    cooldown.offer(new int[] {count, time + n + 1});
                }
            }
        }

        return time;
    }
}
