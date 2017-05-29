/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/gfs-client
@Language: Java
@Datetime: 16-09-01 08:26
*/

/* Definition of BaseGFSClient
 * class BaseGFSClient {
 *     private Map<String, String> chunk_list;
 *     public BaseGFSClient() {}
 *     public String readChunk(String filename, int chunkIndex) {
 *         // Read a chunk from GFS
 *     }
 *     public void writeChunk(String filename, int chunkIndex,
 *                            String content) {
 *         // Write a chunk to GFS
 *     }
 * }
 */
public class GFSClient extends BaseGFSClient {
    private int chunkSize;
    private Map<String, Integer> file_chunk_list;
    public GFSClient(int chunkSize) {
        // initialize your data structure here
        this.chunkSize = chunkSize;
        this.file_chunk_list = new HashMap<String, Integer>();
    }
    
    // @param filename a file name
    // @return conetent of the file given from GFS
    public String read(String filename) {
        // Write your code here
        String content = "";
        if (!file_chunk_list.containsKey(filename)) {
            return null;
        }
        String tmp = null;
        int chunkIndex = file_chunk_list.get(filename);
        int cur_index = 0;
        while (cur_index <= chunkIndex && (tmp = readChunk(filename, cur_index)) != null) {
            content += tmp;
            cur_index++;
        }
        return content;
    }

    // @param filename a file name
    // @param content a string
    // @return void
    public void write(String filename, String content) {
        // Write your code here
        String tmp = null;
        int chunkIndex = content.length() / chunkSize - 1;
        if (content.length() % chunkSize != 0) {
            chunkIndex++;
        }
        file_chunk_list.put(filename, chunkIndex);
        int cur_index = 0;
        while (content.length() > chunkSize) {
            tmp = content.substring(0, chunkSize);
            writeChunk(filename, cur_index, tmp);
            content = content.substring(chunkSize);
            cur_index++;
        }
        writeChunk(filename, cur_index, content);
        return;
    }
}