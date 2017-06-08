/**
 * 创建一个Client.java的客户端程序
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
			//获取输入流与输出流
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw=new PrintWriter(socket.getOutputStream(),true);
			//向服务器发送数据
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
