package jiuzhang;

public class FindString {
	/**
	 * Returns a index to the first occurrence of target in source,
	 * or -1  if target is not part of source.
	 * @param source string to be scanned.
	 * @param target string containing the sequence of characters to match.
	 *提示：KMP，O(n+m)
	 *codeing style:if后面最好有空格，双元运算符两边加空格，逗号、分号后加空格；异常处理、主处理、返回空行
	 *异常检测，边界处理
	 *编程基本功：程序风格（缩进、括号、变量名）、Coding习惯（异常检查、边界处理）、沟通（让面试官时刻明白你的意图）、测试（主动写出合理的testcase）
	 *刷题：总结归纳类似问题解法；找出模板程序（递归、动规、广度优先、深度优先 ）；
	 */
    public int strStr(String source,String target){
    	 // write your code here
        if (source == null || target == null){
            return -1;
        }//异常处理
        
        int i, j;
        for (i = 0; i < source.length() - target.length() + 1; i++){
            for (j = 0; j < target.length(); j++){
                if (source.charAt(i+j) != target.charAt(j)){
                    break;
                }
            }
            if (j == target.length()){
                return i;
            }
        }//算法处理
        
        return -1;//返回值
    }
    
}
