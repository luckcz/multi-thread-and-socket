package com.kaicom.test;

import org.junit.Test;

import com.kaicom.thread.MyThread;
import com.kaicom.thread.MyThread2;
import com.kaicom.thread.MyThread4;
import com.kaicom.thread.MyThread5;
import com.kaicom.thread.MyThread6;
import com.kaicom.thread.MyThread7;
import com.kaicom.thread.MyThread8;
/**
 * 实际上 Thread 类和 Runnable 接口之间在使用上也是有区别的，
 * 如果一个类继承 Thread类，则不适合于多个线程共享资源，而实现了 Runnable 接口，就可以方便的实现资源的共享。
 * 
在此提出一个问题，Java 程序每次运行至少启动几个线程？

回答：至少启动两个线程，每当使用 Java 命令执行一个类时，实际上都会启动一个 JVM，每一个JVM实际上就是在操作系统中启动一个线程，Java 本身具备了垃圾的收集机制。所以在 Java 运行时至少会启动两个线程，一个是 main 线程，另外一个是垃圾收集线程。
 */
public class Function {
	@Test
	public void fun1(){
		MyThread mt1 = new MyThread("线程A ");
		MyThread mt2 = new MyThread("线程B ");
		Thread t1 = new Thread(mt1);
		Thread t2 = new Thread(mt2);
		t1.start();
		t2.start();
	}
	
	@Test
	public void fun2(){
		MyThread2 mt1 = new MyThread2("线程A ");
		MyThread2 mt2 = new MyThread2("线程B ");
		mt1.start();
		mt2.start();
	}
	
	/**
	 * 在线程操作中，可以使用 join() 方法让一个线程强制运行，线程强制运行期间，其他线程无法运行，
	 * 必须等待此线程完成之后才可以继续执行。
	 */
	@Test
	public void fun3(){
		MyThread mt = new MyThread("线程A ");
		Thread t = new Thread(mt);
		t.start();
		for(int i = 0 ; i < 50 ; i ++){
			if(i > 10){
				try {
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(Thread.currentThread().getName()+"线程 --> "+i);
		}
	}
	
	@Test
	public void fun4(){
		MyThread4 mt = new MyThread4("线程A ");
		Thread t = new Thread(mt);
		t.start();
		try {
			t.join();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			 System.out.println("3、休眠被终止") ;
			e.printStackTrace();
		}
		 t.interrupt() ; // 中断线程执行
	}
	
	@Test
	public void fun5(){
		MyThread5 mt = new MyThread5("线程A ");
		Thread t = new Thread(mt);
		t.setDaemon(true);
		t.start();
	}
	
	@Test
	public void fun6(){
		Thread t1 = new Thread(new MyThread("线程A "));
		Thread t2 = new Thread(new MyThread("线程B "));
		Thread t3 = new Thread(new MyThread("线程C "));
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}
	
	/**
	 * 线程礼让 Thread.currentThread().yield();
	 */
	@Test
	public void fun7(){
		Thread t1 = new Thread(new MyThread6("线程A "));
		Thread t2 = new Thread(new MyThread6("线程B "));
		t1.start();
		t2.start();
	}
	
	@Test
	public void fun8(){
		Thread t1 = new Thread(new MyThread7("线程A "));
		Thread t2 = new Thread(new MyThread7("线程B "));
		Thread t3 = new Thread(new MyThread7("线程C "));
		t1.start();
		t2.start();
		t3.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void fun9(){
		Thread t1 = new Thread(new MyThread8("线程A "));
		Thread t2 = new Thread(new MyThread8("线程B "));
		Thread t3 = new Thread(new MyThread8("线程C "));
		t1.start();
		t2.start();
		t3.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
