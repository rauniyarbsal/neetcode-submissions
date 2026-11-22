class Twitter {
    int time;
    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> following;

    public Twitter() {
        time = 0;
        tweets = new HashMap<>();
        following = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k-> new ArrayList<>()).add(new int[]{time, tweetId});

        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]>maxHeap = new PriorityQueue<>(
            (a,b)-> Integer.compare(b[0], a[0])
        );

        if(tweets.containsKey(userId)){

            for(int []tweet: tweets.get(userId)){

                maxHeap.offer(tweet);
            }
        }


        if(following.containsKey(userId)){

            for(int followee: following.get(userId)){

                if(tweets.containsKey(followee)){

                    for(int []tweet: tweets.get(followee)){
                        maxHeap.offer(tweet);

                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!maxHeap.isEmpty() && ans.size() < 10){
            int []tweet = maxHeap.poll();

            ans.add(tweet[1]);
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k->new HashSet<>()).add(followeeId);

    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)){
            following.get(followerId).remove(followeeId);

        }


    }
}
