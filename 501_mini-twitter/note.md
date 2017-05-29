```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/mini-twitter
@Language: Markdown
@Datetime: 17-01-15 09:10
```

public class MiniTwitter {
    class Node {
        public Tweet tweet;
        public int order;
        public Node(Tweet tweet, int order) {
            this.tweet = tweet;
            this.order = order;
        }
    }
    class Order implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if (a.order > b.order) {
                return -1;
            } else {
                return 1;
            }
        }
    }
    private HashMap<Integer, Set<Integer>> friend;
    private HashMap<Integer, List<Node>> users_tweet;
    private int order;
    
    public MiniTwitter() {
        // initialize your data structure here.
        this.friend = new HashMap<Integer, Set<Integer>>();
        this.users_tweet = new HashMap<Integer, List<Node>>();
        this.order = 0;
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        //  Write your code here
        Tweet tweet = Tweet.create(user_id, tweet_text);
        if (!users_tweet.containsKey(user_id)) {
            users_tweet.put(user_id, new ArrayList<Node>());
        }
        order += 1;
        users_tweet.get(user_id).add(new Node(tweet, order));
        return tweet;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
        List<Node> tmp = new ArrayList<Node>();
        List<Tweet> rt = new ArrayList<Tweet>();
        if (friend.containsKey(user_id)) {
            Set<Integer> set = friend.get(user_id);
            for (Integer user : set) {
                tmp.addAll(getFirstTen(user));
            }
        }
        tmp.addAll(getFirstTen(user_id));
        Collections.sort(tmp, new Order());
        Iterator<Node> iter = tmp.iterator();
        while (iter.hasNext()) {
            rt.add(iter.next().tweet);
            if (rt.size() == 10) {
                break;
            }
        }
        return rt;
    }
    
    public List<Node> getFirstTen(int user_id) {
        List<Node> tmp = new ArrayList<Node>();
        if (users_tweet.containsKey(user_id)) {
            tmp = users_tweet.get(user_id);
        }
        Collections.sort(tmp, new Order());
        List<Node> rt = new ArrayList<Node>();
        Iterator<Node> iter = tmp.iterator();
        while (iter.hasNext()) {
            rt.add(iter.next());
            if (rt.size() == 10) {
                break;
            }
        }
        return rt;
    }
        
    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        // Write your code here
        List<Node> tmp = new ArrayList<Node>();
        List<Tweet> rt = new ArrayList<Tweet>();
        if (users_tweet.containsKey(user_id)) {
            tmp = users_tweet.get(user_id);
        }
        Collections.sort(tmp, new Order());
        Iterator<Node> iter = tmp.iterator();
        while (iter.hasNext()) {
            rt.add(iter.next().tweet);
            if (rt.size() == 10) {
                break;
            }
        }
        return rt;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
        if (!friend.containsKey(from_user_id)) {
            friend.put(from_user_id, new HashSet<Integer>());
        }
        friend.get(from_user_id).add(to_user_id);
        return;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        if (friend.containsKey(from_user_id)) {
            friend.get(from_user_id).remove(to_user_id);
        }
        return;
    }
}