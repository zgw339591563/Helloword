package com.atguigu.test1;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Pooltest {

	public static void main(String[] args) {
		//ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
		ExecutorService threadPool1 = Executors.newCachedThreadPool();
		//ExecutorService threadPool1 = Executors.newSingleThreadExecutor();
		testScheduledThreadPool();
		try {
			for(int i=0;i<10;i++){
				Future<Integer> future = threadPool1.submit(new Callable<Integer>() {

					@Override
					public Integer call() throws Exception {
						Random random = new Random();
						System.out.print(Thread.currentThread().getName()+"\t");
						return random.nextInt(500);
					}
				});
				System.out.println("---"+future.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			threadPool1.shutdown();
		}
	}
	//时间调度设置5秒后执行
	public static void testScheduledThreadPool(){
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
		try {
			newScheduledThreadPool.schedule(new Runnable(){

				@Override
				public void run() {
					Random random = new Random();
					System.out.print(Thread.currentThread().getName()+"\t---3"+random.nextInt(500));
					
				}
				
			}, 5, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			newScheduledThreadPool.shutdown();
		}
	}
}
