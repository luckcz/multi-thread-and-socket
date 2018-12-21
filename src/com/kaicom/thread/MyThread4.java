package com.kaicom.thread;

public class MyThread4 implements Runnable{// 继承Thread类，作为线程的实现类 
	private String name ;       // 表示线程的名称 
	
    public MyThread4(String name){ 
        this.name = name ;   
    }
    
	@Override
	public void run() {
		System.out.println("1、进入run()方法") ; 
		try {
			Thread.sleep(10000);  //休眠十秒
			System.out.println("2、已经完成了休眠");
		} catch (InterruptedException e) {
			System.out.println("3、休眠被终止") ; 
			e.printStackTrace();
		}
		 System.out.println("4、run()方法正常结束") ;
	}
}
