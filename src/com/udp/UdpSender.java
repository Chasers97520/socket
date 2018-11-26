package com.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpSender {

	public static void main(String[] args) {
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
			int port=6666;
			DatagramPacket dp=new DatagramPacket(buf,length,address,port);
			socket.send(dp);
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
