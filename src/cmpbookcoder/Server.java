package cmpbookcoder;
import java.io.*;
import java.net.*;
/*��Socketʵ�ֿͻ��˺ͷ���˵�ͨ�ţ�Ҫ��ͻ��˷������ݺ��ܹ�������ͬ������*/
public class Server {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=null;
	    PrintWriter pw=null;
	    try{
	    	ServerSocket server=new ServerSocket(2000);
	    	Socket socket=server.accept();
	    	//��ȡ������
	    	br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    	//��ȡ�����
	    	pw=new PrintWriter(socket.getOutputStream(),true);
	    	String s=br.readLine();//��ȡ���յ�����
	    	pw.println(s);//������ͬ�����ݸ��ͻ���
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
