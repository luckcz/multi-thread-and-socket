package com.kaicom.thread;

public class MyThread8 implements Runnable{// 继承Thread类，作为线程的实现类 
	private static String name ;       // 表示线程的名称 
	private static int ticket = 5 ;     // 假设一共有5张票
    public MyThread8(String name){ 
        this.name = name ;   
    }
    
	@Override
	public void run() {
		for(int i=0;i<10;i++){
           this.sale();
        }
	}
	
	
	public synchronized static void sale(){
		if(ticket > 0){
			//代表还有票
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "  当前票数："+ticket);
			ticket--;
			System.out.println(Thread.currentThread().getName() + "买到票了，剩余票数： "+ticket);
		}else{
			System.out.println("没票了");
			System.out.println(Thread.currentThread().getName()+"已经买不到票了");
		}
	}
}
