package com.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpCommen {

	public static void main(String[] args) {
		new ReceiverThread().start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new SendThread().start();

	}

}

class SendThread extends Thread{
	@Override
	public void run() {

		String message="相思湖学院";
		Scanner sc=new Scanner(System.in);
		
		DatagramSocket socket=null;
		try {
			socket=new DatagramSocket();
			while(true){
			System.out.println("请输入消息");
			message=sc.nextLine(); 
			if("exit".equals(message)){
				break;
			}
			byte[] buf=message.getBytes();
			int length=buf.length;
			InetAddress address=InetAddress.getByName("localhost");
			int port=6661;
			DatagramPacket dp=new DatagramPacket(buf,length,address,port);
			socket.send(dp);
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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

class ReceiverThread extends Thread{
	@Override
	public void run() {


		int port=6661;
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
				System.out.println("接收到:"+str);
				
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
