/**
 * ����һ��Client.java�Ŀͻ��˳���
 */
package cmpbookcoder;
import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=null;
		PrintWriter pw=null;
		try{
			Socket socket=new Socket("localhost",2000);
			//��ȡ�������������
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw=new PrintWriter(socket.getOutputStream(),true);
			//���������������
			pw.println("Hello");
			String s=null;
			while(true){
				s=br.readLine();
				if(s!=null)
					break;
			}
			System.out.println(s);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				br.close();
				pw.close();
			}catch(Exception e){
				
			}
		}

	}

}
