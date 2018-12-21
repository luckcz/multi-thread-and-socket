package com.kaicom.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
 
/**
 * Created by Administrator on 2017/7/26.
 */
public class UDPClinet {
    public static void main(String[] args) {
        /**
         * 向服务器端发送数据
         */
        try {
            //1.定义服务器的地址、端口号以及相应要发送的数据
            InetAddress address=InetAddress.getByName("localhost");
            int port=8800;
            byte data[]="用户名：admin；密码：123".getBytes();
            //2.创建数据报，包含发送的相关数据，服务器地址端口以及信息
            DatagramPacket packet=new DatagramPacket(data,data.length,address,port);
            //3.创建datagramSocket来实现数据的发送
            DatagramSocket socket=new DatagramSocket();
            //4.使用datagramsocket向服务器端发送数据报
            socket.send(packet);
            /**
             * 接收服务端响应的数据
             */
            //1.创建数据报，用来接收服务器端响应的数据，数据保存在字节数组里
            byte [] data2=new byte[1024];
            DatagramPacket packet2=new DatagramPacket(data2,data2.length);
            //2.接收服务器端响应的数据
            socket.receive(packet2);
            //3.读取服务器端相应的数据信息
            String reply=new String(data2,0,packet2.getLength());
            System.out.println("我是客户端，服务器说："+reply);
            //4.关闭资源
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
 
    }
}
