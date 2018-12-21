package com.kaicom.socket;

import java.net.MalformedURLException;
import java.net.URL;

public class Test2 {
	public static void main(String[] args) {
		//创建一个URL的实例
		try {
			URL imooc = new URL("http://www.imooc.com");
			 //根据已创建的URL，来创建新的URL
            URL url=new URL(imooc,"/index.html?username=tom#test");
            //?后面表示参数，#后面表示锚点
            System.out.println("协议："+url.getProtocol());
            System.out.println("主机："+url.getHost());	
          //如果未指定端口号，根据协议不同使用默认端口号，那我们这里HTTP使用的是80
            //此时因为是默认的端口号，所以getPort返回值是-1
            System.out.println("端口号："+url.getPort());
            System.out.println("文件路径："+url.getPath());
            System.out.println("文件名："+url.getFile());
            System.out.println("相对路径："+url.getRef());
            System.out.println("查询字符串："+url.getQuery());//查询字符串就是我们的参数
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
