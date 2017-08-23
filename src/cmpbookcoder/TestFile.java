package cmpbookcoder;
import java.io.File;
public class TestFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        File file=new File("E:\\git\\zr-test\\src\\cmpbookcoder\\testDir");
        //判断目录是否存在
        if(!file.exists()) {
        	System.out.println("directory is empty");
        	return;
        }
        File[] fileList=file.listFiles();
        for(int i=0;i<fileList.length;i++) {
        	//判断是否为目录
        	if(fileList[i].isDirectory()) {
        		System.out.println("directory is: "+fileList[i].getName());
        	}else {
        		System.out.println("file is "+fileList[i].getName());
        	}
        }
	}

}
