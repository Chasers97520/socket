package com.xxx;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {

	public static void main(String[] args) {
		 try {
			 ServerSocket server=new ServerSocket(8888);
			 while(true){
				 System.out.println("�������˿�ʼ�����˿�");
				 Socket client=server.accept();
				 OutputStream os=client.getOutputStream();
				 InputStream in=client.getInputStream();
				 byte[] bytes=new byte[1024];
				 in.read(bytes);
				 System.out.println("�������˽�������:"+new String(bytes));
				 System.out.println("��ͻ��˷�������");
				 os.write("��Ӧ����".getBytes());
				 in.close();
				 os.close();
				 client.close();
				 if(new String(bytes).startsWith("exit")){
					 server.close();
					 break;
				 }
				 
			 }
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
