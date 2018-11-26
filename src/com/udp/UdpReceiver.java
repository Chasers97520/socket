package com.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpReceiver {

	public static void main(String[] args) {
		int port=6666;
		DatagramSocket socket=null;
		try {
			socket=new DatagramSocket(port);
			byte[] buf=new byte[1024];
			int length=buf.length;
			DatagramPacket dp=new DatagramPacket(buf,length);
			while(true){
				socket.receive(dp);
				//从DatagramPacket中获取数据
				byte[] data=dp.getData();
				String str=new String(data,0,dp.getLength());
				System.out.println("接收端收到："+str);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(socket!= null){
				socket.close();
				socket=null;
			}
		}
		
	}

}
