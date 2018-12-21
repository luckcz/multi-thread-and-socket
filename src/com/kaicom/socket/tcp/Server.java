package com.kaicom.socket.tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @project <multithreading> 
 * @company	杭州凯立通信有限公司
 * @author <cz>
 * @date <2018年12月20日上午9:38:51>
 * @description:Socket基于TCP通信，服务器端SeverSocket
 */
public class Server {
	public static void main(String[] args) {
		//1.创建一个服务器端ServerSocket，并且绑定指定的端口号
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null ;
			//记录客户端的数量
			int count = 0 ;
			//2.调用accept()方法开始监听，等待客户端的连接
			System.out.println("***服务器即将启动，等待客户端的连接***");
			while(true){
				socket = serverSocket.accept();
				ServerThread st=new ServerThread(socket);
				st.start();
				count++ ;
				System.out.println("客户端的数量"+count);
				InetAddress inetAddress = socket.getInetAddress();
				System.out.println("当前客户端的IP地址："+inetAddress.getHostAddress());
			}
//          Socket socket=serverSocket.accept();//一旦调用这个方法它就会处于阻塞的状态，等待客户端的请求信息
//          //如果客户端发送连接请求，这个时候我们会接收客户端的请求，并且我们看到accpet方法会返回一个socket的实例
//          //用来与客户端进行通信
//          //一旦与客户端建立socket通信以后，我们下面就需要在客户端和服务器端实现数据的交互，获取客户端提交的登陆
//          //信息，那么如何获取呢？需要通过输入输出流来实现。
//          //3.获取一个输入流，然后来读取客户信息
//          InputStream is=socket.getInputStream();//字节输入流
//          //为了提升效率可以把它包装成一个字符输入流
//          InputStreamReader isr=new InputStreamReader(is);
//          //我们可以为字符流添加缓冲，以缓冲的方式去进行数据的读取
//          BufferedReader br=new BufferedReader(isr);
//          String info=null;
//          while((info=br.readLine())!=null){
//              System.out.println("我是服务器，客户端说"+info);
//          }
//          socket.shutdownInput();//关闭输入流
//          //4.获取输出流，用来服务器端响应客户端的信息
//          OutputStream os=socket.getOutputStream();
//          PrintWriter pw=new PrintWriter(os);
//          pw.write("欢迎您！");
//          pw.flush();
//          //5.关闭相关的资源
//          pw.close();
//          os.close();
//          br.close();
//          isr.close();
//          is.close();
//          socket.close();
          //serverSocket.close();有一个死循环所以无法关闭也不会进展到这一步，所以删掉
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
