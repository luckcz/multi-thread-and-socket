package com.kaicom.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Test1 { 
	public static void main(String[] args) {
		try {
			//获取本机的InetAddress类的实例
			InetAddress localHost = InetAddress.getLocalHost();
			System.out.println("计算机名："+localHost.getHostName());
            System.out.println("IP地址："+localHost.getHostAddress());
            byte[] address = localHost.getAddress();//获取IP地址的字节数组
            System.out.println("字节形式的数组IP："+ Arrays.toString(address));
            System.out.println(localHost);
            
          //根据主机名获取InetAddress实例
            InetAddress address2=InetAddress.getByName("KL-PF224MH");
            System.out.println("计算机名："+address2.getHostName());
            System.out.println("IP地址："+address2.getHostAddress());
            
            /*InetAddress address3=InetAddress.getByAddress("192.168.85.25".getBytes());
            System.out.println("计算机名："+address3.getHostName());
            System.out.println("IP地址："+address3.getHostAddress());*/
            
            InetAddress address4=InetAddress.getByName("192.168.85.172");
            System.out.println("计算机名："+address4.getHostName());
            System.out.println("IP地址："+address4.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
