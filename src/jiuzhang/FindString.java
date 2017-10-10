package jiuzhang;

public class FindString {
	/**
	 * Returns a index to the first occurrence of target in source,
	 * or -1  if target is not part of source.
	 * @param source string to be scanned.
	 * @param target string containing the sequence of characters to match.
	 *��ʾ��KMP��O(n+m)
	 *codeing style:if��������пո�˫Ԫ��������߼ӿո񣬶��š��ֺź�ӿո��쳣�������������ؿ���
	 *�쳣��⣬�߽紦��
	 *��̻����������������������š�����������Codingϰ�ߣ��쳣��顢�߽紦������ͨ�������Թ�ʱ�����������ͼ�������ԣ�����д�������testcase��
	 *ˢ�⣺�ܽ������������ⷨ���ҳ�ģ����򣨵ݹ顢���桢������ȡ�������� ����
	 */
    public int strStr(String source,String target){
    	 // write your code here
        if (source == null || target == null){
            return -1;
        }//�쳣����
        
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
        }//�㷨����
        
        return -1;//����ֵ
    }
    
}
