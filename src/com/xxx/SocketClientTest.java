package com.xxx;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientTest {

	public static void main(String[] args) {
		Socket client=null;
		try {
			client = new Socket("localhost",8888);
			OutputStream os=client.getOutputStream();
			InputStream in=client.getInputStream();
			System.out.println("�ͻ���׼��������");
			String request="�ͻ�����������";
			os.write(request.getBytes());
			byte[] bytes=new byte[1024];
			in.read(bytes);
			System.out.println(new String(bytes));
			if(in != null){
				in.close();
			}
			os.close();
			client.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
