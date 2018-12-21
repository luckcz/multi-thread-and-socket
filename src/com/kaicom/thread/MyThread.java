package com.kaicom.thread;
/**
 * 在 Java 中实现多线程有两种手段，一种是继承 Thread 类，另一种就是实现 Runnable 接口。下面我们就分别来介绍这两种方式的使用
 */
public class MyThread implements Runnable{  // 实现Runnable接口，作为线程的实现类 

	private String name ;
	
	public MyThread(String name){
		this.name = name ;
	}
	
	@Override
	public void run() {
		for(int i = 0 ; i < 10 ; i++){
			System.out.println(name +"运行,i = "+i);
		}
		
	}
}
