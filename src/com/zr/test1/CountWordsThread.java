package com.zr.test1;
import java.util.*;
public class CountWordsThread /*implements Runnable*/{
    /*private FileChannel fileChannel = null;
    private FileLock lock = null;
    private MappedByteBuffer mbBuf = null;
    private Map<String, Integer> hashMap = null;
     
    public CountWordsThread(File file, long start, long end) {
        try {
            // �õ���ǰ�ļ���ͨ��
            fileChannel = new RandomAccessFile(file, "rw").getChannel();
            // ������ǰ�ļ��Ĳ���
            lock = fileChannel.lock(start, end, false);
            // �Ե�ǰ�ļ�Ƭ�ν����ڴ�ӳ�䣬����ļ�������Ҫ�и�ɶ��Ƭ��
            mbBuf = fileChannel.map(FileChannel.MapMode.READ_ONLY, start, end);
            // ����HashMapʵ����Ŵ�����
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
            // ���������ŵ�һ��HashMap��
            word = token.nextToken().toString().trim();
            if(null != hashMap.get(word)) {
                hashMap.put(word, hashMap.get(word) + 1);
            } else {
                hashMap.put(word, 1);
            }
        }
        try {
            // �ͷ��ļ���
            lock.release();
            // �ر��ļ�ͨ��
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
     
    //��ȡ��ǰ�̵߳�ִ�н��
    public Map<String, Integer> getResultMap() {
        return hashMap;
    }
}
 
DealFileText.java
 
public class DealFileText {
 
    // Ҫ������ļ�
    private File file = null;
     
    // �߳�������
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
        // ���������̷ֱ߳����ļ��Ĳ�ͬƬ��
        t1.start();
        t2.start();
        Thread mainThread = new Thread() {
            public void run() {
                while(true) {
                    // �����߳̾����н���
                    if(Thread.State.TERMINATED == t1.getState() && Thread.State.TERMINATED == t2.getState()) {
                        // ��ȡ���Դ���Ľ��
                        Map<String, Integer> hMap1 = thread1.getResultMap();
                        Map<String, Integer> hMap2 = thread2.getResultMap();
                         
                        // ʹ��TreeMap��֤�������
                        TreeMap<String, Integer> tMap = new TreeMap<String, Integer>();
                        // �Բ�ͬ�̴߳���Ľ����������
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
        // ÿ�߳�Ӧ�ö�ȡ���ֽ���
        long numPerThred = this.file.length() / this.threads.length;
        // �����ļ�������ʣ�µ�����
        long left = this.file.length() % this.threads.length;
        Thread  tempThread = null;
        for (int i = 0; i < this.threads.length; i++) {
            // ��ÿ���̷ֱ߳����ȡ�ļ��Ĳ�ͬ���֡�
            try {               
                // ���һ���̶߳�ȡָ��numPerThred+left���ֽ�
                if (i == this.threads.length - 1) {
                    this.threads[i] = new CountWordsThread(file,i * numPerThred, (i + 1)
                            * numPerThred + left);
                } else {// ÿ���̸߳����ȡһ����numPerThred���ֽ�                   
                    this.threads[i] = new CountWordsThread(file,i * numPerThred, (i + 1)
                            * numPerThred );
                }
                tempThread = new Thread(threads[i]);
                tempThread.start();
                listThread.add(tempThread);   
            } catch (Exception e) {
                System.out.println("ϵͳ�������ش���ϵͳ����ֹ���У�");
                e.printStackTrace();
                System.exit(-1);// ϵͳ�˳�
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
                System.out.println("���ִ����������ǡ� " + key + "��" + "  ����Ϊ����" + map.get(key) + "��");
            }
        }       
    }*/
}
