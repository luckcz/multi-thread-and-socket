package com.kaicom.thread;

public class MyThread6 implements Runnable{// 继承Thread类，作为线程的实现类 
	private String name ;       // 表示线程的名称 
	
    public MyThread6(String name){ 
        this.name = name ;   
    }
    
	@Override
	public void run() {
		for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i) ; 
            if(i == 2){
            	System.out.println("线程礼让：");
            	Thread.currentThread().yield();
            }
        }
	}
}
