class Twitter {

    // Global timestamp to determine tweet recency
    private int time;

    // userId -> list of {time, tweetId}
    private Map<Integer, List<int[]>> tweets;

    // followerId -> set of followeeIds
    private Map<Integer, Set<Integer>> following;

    public Twitter() {
        time = 0;
        tweets = new HashMap<>();
        following = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        tweets.computeIfAbsent(
            userId,
            k -> new ArrayList<>()
        );

        // Store {time, tweetId}
        tweets.get(userId).add(
            new int[]{time, tweetId}
        );

        time++;
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> ans = new ArrayList<>();

        // Users whose tweets should appear in the feed
        Set<Integer> users = new HashSet<>();

        // Include user's own tweets
        users.add(userId);

        // Include people they follow
        if (following.containsKey(userId)) {
            users.addAll(following.get(userId));
        }

        /*
         * Heap entry:
         *
         * {time, tweetId, userId, tweetIndex}
         *
         * Max heap based on time.
         */
        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0], a[0])
            );

        // Add only the newest tweet from each relevant user
        for (int uid : users) {

            if (!tweets.containsKey(uid)) {
                continue;
            }

            List<int[]> userTweets = tweets.get(uid);

            int lastIdx = userTweets.size() - 1;

            int[] tweet = userTweets.get(lastIdx);

            maxHeap.offer(new int[]{
                tweet[0],   // time
                tweet[1],   // tweetId
                uid,        // userId
                lastIdx     // index in user's tweet list
            });
        }

        // Merge tweet lists by recency
        while (!maxHeap.isEmpty() && ans.size() < 10) {

            int[] curr = maxHeap.poll();

            int tweetId = curr[1];
            int uid = curr[2];
            int tweetIdx = curr[3];

            // Current newest tweet
            ans.add(tweetId);

            // Get next older tweet from SAME user
            int nextIdx = tweetIdx - 1;

            if (nextIdx >= 0) {

                int[] nextTweet =
                    tweets.get(uid).get(nextIdx);

                maxHeap.offer(new int[]{
                    nextTweet[0],   // time
                    nextTweet[1],   // tweetId
                    uid,
                    nextIdx
                });
            }
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {

        following
            .computeIfAbsent(
                followerId,
                k -> new HashSet<>()
            )
            .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}