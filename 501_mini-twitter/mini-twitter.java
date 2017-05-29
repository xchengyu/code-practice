/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/mini-twitter
@Language: Java
@Datetime: 17-01-15 09:10
*/

/**
 * Definition of Tweet:
 * public class Tweet {
 *     public int id;
 *     public int user_id;
 *     public String text;
 *     public static Tweet create(int user_id, String tweet_text) {
 *         // This will create a new tweet object,
 *         // and auto fill id
 *     }
 * }
 */
class Node {
    public Tweet tweet;
    public int time;
    public Node(Tweet tweet, int time) {
        this.tweet = tweet;
        this.time = time;
    }
}
class Order implements Comparator<Node> {
    public int compare(Node a, Node b) {
        return b.time - a.time;
    }
}
public class MiniTwitter {
    public Map<Integer, Set<Integer>> friends;
    public Map<Integer, List<Node>> users_tweet;
    private int clock;
    public MiniTwitter() {
        // initialize your data structure here.
        this.friends = new HashMap<Integer, Set<Integer>>();
        this.users_tweet = new HashMap<Integer, List<Node>>();
        this.clock = 0;
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
        clock += 1;
        users_tweet.get(user_id).add(new Node(tweet, clock));
        return tweet;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
        List<Node> tmp = new ArrayList<Node>();
        List<Tweet> rt = new ArrayList<Tweet>();
        if (friends.containsKey(user_id)) {
            Set<Integer> set = friends.get(user_id);
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
        
    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        // Write your code here
        List<Node> tmp = new ArrayList<Node>();
        List<Tweet> rt = new ArrayList<Tweet>();
        if (users_tweet.containsKey(user_id)) {
            tmp = users_tweet.get(user_id);
            Collections.sort(tmp, new Order());
        }
        
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
        List<Node> rt = new ArrayList<Node>();
        List<Node> tmp = new ArrayList<Node>();
        if (users_tweet.containsKey(user_id)) {
            tmp = users_tweet.get(user_id);
            Collections.sort(tmp, new Order());
        }
        
        Iterator<Node> iter = tmp.iterator();
        while (iter.hasNext()) {
            rt.add(iter.next());
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
        if (!friends.containsKey(from_user_id)) {
            friends.put(from_user_id, new HashSet<Integer>());
        }
        friends.get(from_user_id).add(to_user_id);
        return;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        if (friends.containsKey(from_user_id)) {
            friends.get(from_user_id).remove(to_user_id);
        }
        return;
    }
}