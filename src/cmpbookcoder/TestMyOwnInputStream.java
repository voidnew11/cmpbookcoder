package cmpbookcoder;
import java.io.*;

class MyOwnInputStream extends FilterInputStream{
    public MyOwnInputStream(InputStream in) {
    	super(in);
    }
    public int read() throws IOException{
    	int c=0;
    	if((c=super.read())!=-1) {
    		//小写转大写
    		if(Character.isLowerCase((char)c)) {
    			return Character.toUpperCase((char)c);
    		}else if(Character.isUpperCase((char)c)) {
    			//大写转小写
    			return Character.toLowerCase((char)c);
    		}else {
    			return c;
    		}
    	}else {
    		return -1;
    	}
    }

}
public class TestMyOwnInputStream{
	public static void main(String[] args) {
		int c;
		try {
			InputStream is=new MyOwnInputStream(new BufferedInputStream(new FileInputStream("E:\\git\\zr-test\\src\\cmpbookcoder\\test.txt")));
			while((c=is.read())>=0) {
				System.out.println((char)c);
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
