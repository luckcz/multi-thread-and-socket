package com.kaicom.thread;

public class MyThread2 extends Thread{// 继承Thread类，作为线程的实现类 
	private String name ;       // 表示线程的名称 
	
    public MyThread2(String name){ 
        this.name = name ;   
    }
    
	@Override
	public void run() {
		for(int i=0;i<100;i++){ 
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i) ; 
        } 
	}
}
