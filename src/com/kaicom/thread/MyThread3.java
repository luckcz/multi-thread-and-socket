package com.kaicom.thread;

public class MyThread3 implements Runnable{// 继承Thread类，作为线程的实现类 
	private String name ;       // 表示线程的名称 
	
    public MyThread3(String name){ 
        this.name = name ;   
    }
    
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i) ; 
            System.out.println(Thread.currentThread().isAlive()) ; 
        } 
	}
}
