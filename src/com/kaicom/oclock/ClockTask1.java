package com.kaicom.oclock;

public class ClockTask1 {
	/**
	 * 普通thread 
	 * 这是最常见的，创建一个thread，然后让它在while循环里一直运行着， 
	 * 通过sleep方法来达到定时任务的效果。这样可以快速简单的实现，代码如下： 
	 */
	public static void main(String[] args) {
		Runnable runable = new Runnable() {
			int i = 1 ;
			@Override
			public void run() {
				while(true){
					System.out.println("数数到："+ (i++));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread thread = new Thread(runable);
		thread.start();
	}
}
