package com.kaicom.thread;

public class MyThread5 implements Runnable{// 继承Thread类，作为线程的实现类 
	private String name ;       // 表示线程的名称 
	
    public MyThread5(String name){ 
        this.name = name ;   
    }
    
	@Override
	public void run() {
		while(true){
			System.out.println(Thread.currentThread().getName() + "在运行。。。。。。。");
		}
	}
}
