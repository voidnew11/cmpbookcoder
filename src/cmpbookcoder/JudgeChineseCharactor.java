package cmpbookcoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class JudgeChineseCharactor {
    public static void judgeChineseCharactor(String str) {
    	String regEx="[\u4e00-\u9fa5]";
    	//判断是否存在中文字符
    	if(str.getBytes().length==str.length()) {
    		System.out.println("无汉字");
    	}else {
    		//若存在中文字符，找出字符串中的中文字符
    		Pattern p=Pattern.compile(regEx);
    		Matcher m=p.matcher(str);
    		while(m.find()) {
    			System.out.print(m.group(0)+"");
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        judgeChineseCharactor("Hello World");
        judgeChineseCharactor("Hello 你好");
	}

}
