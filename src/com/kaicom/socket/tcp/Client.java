package com.kaicom.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @project <multithreading> 
 * @company	杭州凯立通信有限公司
 * @author <cz>
 * @date <2018年12月20日下午1:45:20>
 * @description:客户端
 */
public class Client {
	public static void main(String[] args) {
		try {
			//1.创建socket用来与服务器端进行通信，发送请求建立连接，指定服务器地址和端口
			Socket socket = new Socket("localhost", 8888);
			//2.获取输出流用来向服务器端发送登陆的信息
			OutputStream os = socket.getOutputStream();//字节输出流
			PrintWriter pw=new PrintWriter(os);//将输出流包装成打印流
			pw.write("用户名：admin；密码：12345678");
	        pw.flush();
	        socket.shutdownOutput();//关闭输出流
	        //3.获取输入流，用来读取服务器端的响应信息
	        InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));//添加缓冲
            String info=null;
            while((info=br.readLine())!=null){
                System.out.println("我是客户端，服务器端说"+info);
            }
          //4.关闭其他相关资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
