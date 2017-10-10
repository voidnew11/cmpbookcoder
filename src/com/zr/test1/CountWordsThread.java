package com.zr.test1;
import java.util.*;
public class CountWordsThread /*implements Runnable*/{
    /*private FileChannel fileChannel = null;
    private FileLock lock = null;
    private MappedByteBuffer mbBuf = null;
    private Map<String, Integer> hashMap = null;
     
    public CountWordsThread(File file, long start, long end) {
        try {
            // 得到当前文件的通道
            fileChannel = new RandomAccessFile(file, "rw").getChannel();
            // 锁定当前文件的部分
            lock = fileChannel.lock(start, end, false);
            // 对当前文件片段建立内存映射，如果文件过大需要切割成多个片段
            mbBuf = fileChannel.map(FileChannel.MapMode.READ_ONLY, start, end);
            // 创建HashMap实例存放处理结果
            hashMap = new HashMap<String,Integer>();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        String str = Charset.forName("UTF-8").decode(mbBuf).toString();
        StringTokenizer token = new StringTokenizer(str);
        String word = null;       
        while(token.hasMoreTokens()) {
            // 将处理结果放到一个HashMap中
            word = token.nextToken().toString().trim();
            if(null != hashMap.get(word)) {
                hashMap.put(word, hashMap.get(word) + 1);
            } else {
                hashMap.put(word, 1);
            }
        }
        try {
            // 释放文件锁
            lock.release();
            // 关闭文件通道
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
     
    //获取当前线程的执行结果
    public Map<String, Integer> getResultMap() {
        return hashMap;
    }
}
 
DealFileText.java
 
public class DealFileText {
 
    // 要处理的文件
    private File file = null;
     
    // 线程数数组
    private CountWordsThread[] threads = null;
     
    private List<Thread> listThread = null;
     
    public DealFileText(File file){
        this.file = file;
    }
     
    public DealFileText(File file , int threadNum){
        this.file = file;
        this.threads = new CountWordsThread[threadNum];
    }
 
    public void dealFile(){
        final CountWordsThread thread1 = new CountWordsThread(file, 0, file.length()/2);
        final CountWordsThread thread2 = new CountWordsThread(file, file.length()/2, file.length());
        final Thread t1 = new Thread(thread1);
        final Thread t2 = new Thread(thread2);
        // 开启两个线程分别处理文件的不同片段
        t1.start();
        t2.start();
        Thread mainThread = new Thread() {
            public void run() {
                while(true) {
                    // 两个线程均运行结束
                    if(Thread.State.TERMINATED == t1.getState() && Thread.State.TERMINATED == t2.getState()) {
                        // 获取各自处理的结果
                        Map<String, Integer> hMap1 = thread1.getResultMap();
                        Map<String, Integer> hMap2 = thread2.getResultMap();
                         
                        // 使用TreeMap保证结果有序
                        TreeMap<String, Integer> tMap = new TreeMap<String, Integer>();
                        // 对不同线程处理的结果进行整合
                        tMap.putAll(hMap1);
                        tMap.putAll(hMap2);
                         
                        Map<String, Integer> map = maxCountOfCharacters(tMap);
                        showMessage(map);       
                         
                        t1.interrupt();
                        t2.interrupt();
                        return;
                    }
                }
            }
        };
        mainThread.start();
    }
     
    public void createThreads(){
        listThread = new ArrayList<Thread>();
        // 每线程应该读取的字节数
        long numPerThred = this.file.length() / this.threads.length;
        // 整个文件整除后剩下的余数
        long left = this.file.length() % this.threads.length;
        Thread  tempThread = null;
        for (int i = 0; i < this.threads.length; i++) {
            // 让每个线程分别负责读取文件的不同部分。
            try {               
                // 最后一个线程读取指定numPerThred+left个字节
                if (i == this.threads.length - 1) {
                    this.threads[i] = new CountWordsThread(file,i * numPerThred, (i + 1)
                            * numPerThred + left);
                } else {// 每个线程负责读取一定的numPerThred个字节                   
                    this.threads[i] = new CountWordsThread(file,i * numPerThred, (i + 1)
                            * numPerThred );
                }
                tempThread = new Thread(threads[i]);
                tempThread.start();
                listThread.add(tempThread);   
            } catch (Exception e) {
                System.out.println("系统出现严重错误！系统将终止运行！");
                e.printStackTrace();
                System.exit(-1);// 系统退出
            }
        }       
    }
     
     
    public void doResult(){
        if(null != listThread && listThread.size() > 0){
            for(int i=0;i<listThread.size(); i++){
                 
            }
        }
    }
     
    public List<CountWordsThread> doThread(CountWordsThread thread){
        List<CountWordsThread> list = new ArrayList<CountWordsThread>();
        list.add(thread);
        return list;
    } 
     
    public static Map<String, Integer> maxCountOfCharacters(Map<String, Integer> chineseCounts) {
        if (chineseCounts == null) {
            return null;
        }
        Set<String> keys = chineseCounts.keySet();
        Iterator<String> iterator = keys.iterator();
        int max = 0;
        Map<String, Integer> result = new HashMap<String, Integer>();
        while (iterator.hasNext()) {
            String currChar = iterator.next();
            int currCount = chineseCounts.get(currChar);
            if (currCount > max) {
                max = currCount;
                result.clear();
                result.put(currChar, max);
            } else if (currCount == max) {
                result.put(currChar, max);
            }
        }
        return result;
    }
     
    public static void showMessage(Map<String, Integer> map){
        if(null != map && map.size() > 0){
            Set<String> keys = map.keySet();
            Iterator<String> iterator = keys.iterator();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                System.out.println("出现次数最多的人是【 " + key + "】" + "  次数为：【" + map.get(key) + "】");
            }
        }       
    }*/
}
