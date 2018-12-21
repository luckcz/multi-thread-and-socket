package com.kaicom.socket.udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
 
/**
 * Created by Administrator on 2017/7/26.
 * 服务器端，基于UDP的用户登陆
 */
public class UDPServer {
    public static void main(String[] args) {
        /**
         * 接受客户端发送的数据
         */
        try {
            //1.创建服务器端DatagramSocket，并且指定端口
            DatagramSocket socket=new DatagramSocket(8800);
            //2.创建数据报，用于接收客户端发送的数据
            byte[] data=new byte[1024];
            DatagramPacket packet=new DatagramPacket(data,data.length);//接受信息的数组以及接收的长度
            //3.接收客户端发送的数据
            System.out.println("***服务器端已经启动，等待客户端发送数据***");
            socket.receive(packet);//此方法在接收到数据报之前会一直阻塞
            //4.读取这个数据
            //实际上信息已经保存在字节数组当中，所以这个时候直接转化就好了
            String info=new String(data,0,packet.getLength());
            System.out.println("我是服务器，客户端说："+info);
            /**
             * 向客户端响应数据
             */
            //1.定义客户端的地址，端口号和数据
            InetAddress adress=packet.getAddress();
            int port=packet.getPort();
            byte []data2="欢迎您".getBytes();
            //2.创建数据报，包含响应的数据信息，
            DatagramPacket packet2=new DatagramPacket(data2,data2.length,adress,port);
            //3.响应客户端
            socket.send(packet2);
            //4.关闭相应的资源信息
            socket.close();
 
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
 
    }
}   
