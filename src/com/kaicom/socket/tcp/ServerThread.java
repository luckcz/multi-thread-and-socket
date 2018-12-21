package com.kaicom.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * @project <multithreading> 
 * @company	杭州凯立通信有限公司
 * @author <cz>
 * @date <2018年12月20日下午1:33:09>
 * @description:服务器端线程处理类
 */
public class ServerThread extends Thread{
	//每个客户端请求了以后，服务器端都会创建一个socket，与之进行通信，所以我们每个线程都对应了一个与
    //本线程相关的socket
	Socket socket=null;
	//构造方法初始化
    public ServerThread(Socket socket){
        this.socket=socket;
    }
    //线程执行的操作，响应客户端的请求
	@Override
	public void run() {
		InputStream is = null;//字节输入流
        InputStreamReader isr=null;
        BufferedReader br=null;
        OutputStream os=null;
        PrintWriter pw=null;
		try {
			is = socket.getInputStream();
			//3.获取输入流读取客户端的信息
            //为了提升效率可以把它包装成一个字符输入流
			isr = new InputStreamReader(is);
			//我们可以为字符流添加缓冲，以缓冲的方式去进行数据的读取
			br = new BufferedReader(isr);
			String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器，客户端说" + info);
            }
            socket.shutdownInput();//关闭输入流
            //4.获取输出流，用来服务器端响应客户端的信息
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎你！！！");
            pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5.关闭相关的资源,finally是一定会被执行的
            try {
                if(pw!=null)
                    pw.close();
                if(os!=null)
                    os.close();
                if(br!=null)
                    br.close();
                if(isr!=null)
                    isr.close();
                if(is!=null)
                    is.close();
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}
}
