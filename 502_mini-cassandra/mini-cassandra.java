/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/mini-cassandra
@Language: Java
@Datetime: 16-07-24 07:29
*/

/**
 * Definition of Column:
 * public class Column {
 *     public int key;
 *     public String value;
 *     public Column(int key, String value) {
 *         this.key = key;
 *         this.value = value;
 *    }
 * }
 */
public class MiniCassandra {
    public Map<String, List<Column>> db;
    public Map<String, Set<Integer>> raw;
    public MiniCassandra() {
        // initialize your data structure here.
        db = new HashMap<String, List<Column>>();
        raw = new HashMap<String, Set<Integer>>();
    }
    
    /**
     * @param raw_key a string
     * @param column_start an integer
     * @param column_end an integer
     * @return void
     */
    public void insert(String raw_key, int column_key, String column_value) {
        // Write your code here
        if (!db.containsKey(raw_key)) {
            db.put(raw_key, new ArrayList<Column>());
        }
        if (!raw.containsKey(raw_key)) {
            raw.put(raw_key, new HashSet<Integer>());
        }
        List<Column> col = db.get(raw_key);
        Set<Integer> eachRaw = raw.get(raw_key);
        if (eachRaw.contains(column_key)) {
            for (Column elem : col) {
                if (elem.key == column_key) {
                    elem.value = column_value;
                }
            }
            return;
        }
        col.add(new Column(column_key, column_value));
        eachRaw.add(column_key);
        Collections.sort(col, new Comparator<Column>() {
            public int compare(Column a, Column b) {
                return a.key >= b.key ? 1 : -1;
            }
            
        });
        db.put(raw_key, col);
        raw.put(raw_key, eachRaw);
    }

    /**
     * @param raw_key a string
     * @param column_start an integer
     * @param column_end an integer
     * @return a list of Columns
     */
    public List<Column> query(String raw_key, int column_start, int column_end) {
        // Write your code here
        List<Column> res = new ArrayList<Column>();
        if (!db.containsKey(raw_key)) {
            return res;
        }
        List<Column> col = db.get(raw_key);
        for (Column elem : col) {
            if (elem.key >= column_start && elem.key <= column_end) {
                res.add(elem);
            }
        }
        return res;
    }
}