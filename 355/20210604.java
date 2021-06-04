class Twitter {
    int recentMax,time;
    Map<Integer,Integer> tweettime;
    Map<Integer,Node> user;
    /** Initialize your data structure here. */
    public Twitter() {
        time=0;
        recentMax=10;
        tweettime=new HashMap<>();
        user=new HashMap<>();
    }
    public void init(int usedId){
        user.put(usedId,new Node());
    }
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!user.containsKey(userId)){
            init(userId);
        }
        if(user.get(userId).tweet.size()==recentMax){
            user.get(userId).tweet.remove(recentMax-1);
        }
        user.get(userId).tweet.addFirst(tweetId);
        tweettime.put(tweetId,++time);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> ans=new LinkedList<>();
        for(int it:user.getOrDefault(userId,new Node()).tweet){
            ans.addLast(it);
        }
        for(int id:user.getOrDefault(userId,new Node()).follows){
            if(id==userId){
                continue;
            }
            LinkedList<Integer> res = new LinkedList<Integer>();
            int tweetSize = user.get(id).tweet.size();
            Iterator<Integer> it = user.get(id).tweet.iterator();
            int i = 0;
            int j = 0;
            int curr = -1;
            if(j<tweetSize){
                curr=it.next();
                while(i<ans.size()||j<tweetSize){
                    int time1=j<tweetSize?tweettime.get(curr):-1;
                    int time2=i<ans.size()?tweettime.get(ans.get(i)):-1;
                    if(time1>time2){
                        res.addLast(curr);
                        ++j;
                        if(it.hasNext()){
                            curr=it.next();
                        }
                    }else{
                        res.addLast(ans.get(i));
                        i++;
                    }
                    if(res.size()==recentMax){
                        break;
                    }
                }
            }
            ans=new LinkedList<>(res);
        }
        return ans;

    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!user.containsKey(followerId)){
            init(followerId);
        }
        if(!user.containsKey(followeeId)){
            init(followeeId);
        }
        user.get(followerId).follows.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        user.getOrDefault(followerId,new Node()).follows.remove(followeeId);
    }
}

class Node{
    Set<Integer> follows;
    LinkedList<Integer> tweet;
    public Node(){
        follows=new HashSet<>();
        tweet=new LinkedList<>();
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