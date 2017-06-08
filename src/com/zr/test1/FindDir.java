package com.zr.test1;
import java.io.File;
public class FindDir {
/*列出一个目录下的所有目录和文件，用到管理文件和文件夹的类File*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       File file=new File("G:\\Hello-World");
       //判断目录是否存在
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
