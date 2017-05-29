/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/friendship-service
@Language: Java
@Datetime: 16-12-17 01:21
*/

class Relation {
    private Set<Integer> followings;
    private Set<Integer> followers;
    
    public Relation() {
        this.followings = new HashSet<Integer>();
        this.followers = new HashSet<Integer>();
    }
    
    public Set<Integer> checkFollowings() {
        return this.followings;
    }
    
    public Set<Integer> checkFollowers() {
        return this.followers;
    }
}
public class FriendshipService { 
    private Map<Integer,Relation> relations;
    public FriendshipService() {
        // initialize your data structure here.
        relations = new HashMap<Integer, Relation>();
    }

    // @param user_id an integer
    // return all followers and sort by user_id
    public List<Integer> getFollowers(int user_id) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (relations.containsKey(user_id)) {
            Set<Integer> followers = relations.get(user_id).checkFollowers();
            result.addAll(followers);
            Collections.sort(result);
        }
        return result;
    }
        
    // @param user_id an integer
    // return all followings and sort by user_id
    public List<Integer>  getFollowings(int user_id) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (relations.containsKey(user_id)) {
            Set<Integer> followings = relations.get(user_id).checkFollowings();
            result.addAll(followings);
            Collections.sort(result);
        }
        return result;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
        if (!isExist(from_user_id)) {
            relations.put(from_user_id, new Relation());
        }
        if (!isExist(to_user_id)) {
            relations.put(to_user_id, new Relation());
        }
        relations.get(from_user_id).checkFollowers().add(to_user_id);
        relations.get(to_user_id).checkFollowings().add(from_user_id);
        return;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        if (!isExist(from_user_id) || !isExist(to_user_id)) {
            return;
        }
        relations.get(from_user_id).checkFollowers().remove(to_user_id);
        relations.get(to_user_id).checkFollowings().remove(from_user_id);
    }
    
    private boolean isExist(int id) {
        return relations.containsKey(id);
    }
}