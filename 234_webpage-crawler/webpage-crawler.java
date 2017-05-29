/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/webpage-crawler
@Language: Java
@Datetime: 16-08-07 01:50
*/

/**
 * public class HtmlHelper {
 *     public static List<String> parseUrls(String url);
 *         // Get all urls from a webpage of given url. 
 * }
*/
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.lang.Thread;
import java.net.*;
import java.io.*;
class CrawlerThread extends Thread {
    private static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
    private static AtomicLong counter;
    private static Set<String> visit = new HashSet<String>();
    private static List<String> result = new ArrayList<String>();
    public static void initQueue(String url, int thread_num) {
        counter = new AtomicLong(thread_num);
        try {
            queue.put(url);
        } catch (InterruptedException e) {
            // e.printStackTrace(); 
        }
    }
    public static List<String> getResults() {
        return result;
    }
    public static Long getCounter() {
        return counter.get();
    }
    public void run() {
        while (true) {
            String url = "";
            try {
                counter.decrementAndGet();
                url = queue.take();
                counter.incrementAndGet();

            } catch (Exception e) {//由于是blockingqueue，当queue为空时，任何线程都无法调用queue.take()函数
                // e.printStackTrace();
                break;//当主线程call thread_pool[i].stop();时传入一个interrupt，处于wait状态的子线程捕捉到这个interrupt从而break;
            }

            String domain = "";
            try {
                URL netUrl = new URL(url);
                domain = netUrl.getHost();
            } catch (MalformedURLException e) {
                // e.printStackTrace();
            }
            if (!visit.contains(url) && domain.endsWith("wikipedia.org")) {
                result.add(url);
                visit.add(url);
                List<String> urls = HtmlHelper.parseUrls(url);
                for (String u : urls) {
                    try {
                        queue.put(u);
                    } catch (InterruptedException e) {//由于是blockingqueue，当queue满时，任何线程都无法调用queue.put()函数
                            // e.printStackTrace(); 
                    }
                }
            }
        }
        return;
    }
}
public class Solution {
    /**
     * @param url a url of root page
     * @return all urls
     */
    public List<String> crawler(String url) {
        // Write your code here
        int thread_num = 7;
        CrawlerThread.initQueue(url, thread_num);
        CrawlerThread[] thread_pool = new CrawlerThread[7];
        for (int i = 0; i < thread_pool.length; i++) {
            thread_pool[i] = new CrawlerThread();
            thread_pool[i].start();
        }
        while (CrawlerThread.getCounter() > 0);
        for (int i = 0; i < thread_pool.length; i++) {
            thread_pool[i].stop();
        }
        List<String> results = CrawlerThread.getResults();
        return results;
        
    }
}