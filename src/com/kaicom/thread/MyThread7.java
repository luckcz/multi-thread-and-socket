package com.kaicom.thread;

public class MyThread7 implements Runnable{// 继承Thread类，作为线程的实现类 
	private String name ;       // 表示线程的名称 
	private static int ticket = 5 ;     // 假设一共有5张票
    public MyThread7(String name){ 
        this.name = name ;   
    }
    
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			buy();
        }
	}
	
	static void buy(){
		synchronized (MyThread7.class) {
			if(ticket > 0){
				//代表还有票
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "  当前票数："+ticket);
				ticket--;
				System.out.println(Thread.currentThread().getName() + "买到票了，剩余票数： "+ticket);
			}else{
				System.out.println("当前票数："+ticket);
				System.out.println(Thread.currentThread().getName()+"已经买不到票了");
			}
		}
	}
}
