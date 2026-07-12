class Twitter {

    private int timestamp;
    private Map<Integer, List<int[]>> userTweets;

    /**
        set of {userId and followerId}
     */
    private Map<Integer, Set<Integer>> userFollowers;

    public Twitter() {
        timestamp = 0;
        userTweets = new HashMap<>();
        userFollowers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> tweets = userTweets.getOrDefault(userId, new ArrayList<>());
        tweets.add(new int[]{timestamp++, tweetId});
        userTweets.put(userId, tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {

        // {timestamp, tweetId}
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        addTweets(userId, pq);

        Set<Integer> followersList = userFollowers.getOrDefault(userId, new HashSet<>());
        for(int follower : followersList){
            addTweets(follower, pq);
        }

        int count = 0;
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty() && count < 10){
            result.add(pq.poll()[1]);
            count++;
        }
        return result;
    }

    private void addTweets(int userId, Queue<int[]> pq){
        List<int[]> tweets = userTweets.getOrDefault(userId, new ArrayList<>());
        for(int i = tweets.size() - 1 ; i >= 0  && i >= tweets.size() - 10; i--){
            pq.add(tweets.get(i));
        }
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> following = userFollowers.getOrDefault(followerId, new HashSet<>());
        following.add(followeeId);
        userFollowers.put(followerId, following);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(userFollowers.containsKey(followerId)){
            userFollowers.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */