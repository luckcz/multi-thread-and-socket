package com.kaicom.oclock;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ClockTask2 {
	
	/**
	 * 于第一种方式相比，优势 1>当启动和去取消任务时可以控制 2>第一次执行任务时可以指定你想要的delay时间 
	 * 在实现时，Timer类可以调度任务，TimerTask则是通过在run()方法里实现具体任务。 Timer实例可以调度多任务，它是线程安全的。 
	 * 当Timer的构造器被调用时，它创建了一个线程，这个线程可以用来调度任务。 下面是代码： 
	 */
	public static void main(String[] args) {
		TimerTask task = new TimerTask() {
			int i = 1 ;
			@Override
			public void run() {
				System.out.println(new Date().toLocaleString());
			}
		};
		
		Timer timer = new Timer();
		//首次执行延迟三秒
		long delay = 3000 ;
		long intervalPeriod = 1 * 1000 ;
		timer.schedule(task, delay, intervalPeriod);
	}
}
