package com.xxx;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientTest2 {

	public static void main(String[] args) {
		Socket client;
		try {
			client = new Socket("127.0.0.1",2224);
			OutputStream os=client.getOutputStream();
			InputStream in=client.getInputStream();
			System.out.println("客户端准备发数据");
			String request="exit客户端请求数据";
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
