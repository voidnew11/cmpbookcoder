package com.zr.test1;
import java.io.File;
public class FindDir {
/*�г�һ��Ŀ¼�µ�����Ŀ¼���ļ����õ������ļ����ļ��е���File*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       File file=new File("G:\\Hello-World");
       //�ж�Ŀ¼�Ƿ����
       if(!file.exists()){
    	   System.out.println("directory is empty");
    	   return;
       }
       File[] filelist=file.listFiles();
       for(int i=0;i<filelist.length;i++){
    	   if(filelist[i].isDirectory()){
    		   System.out.println("directory is:"+filelist[i].getName());
    	   }else{
    		   System.out.println("file is:"+filelist[i].getName());
    	   }
       }
	}

}
