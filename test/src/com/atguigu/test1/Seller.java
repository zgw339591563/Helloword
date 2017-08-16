package com.atguigu.test1;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Seller {
	
	public static void main(String[] args) {


			Arrays.asList(1,2,3,4).forEach(System.out::println);
	}
}


class Ticket implements Runnable{ 
	private int tick = 100; 
	private Lock lock = new ReentrantLock();
	@Override 
	public void run() {
		while(true){ 
			lock.lock(); //上锁 
			try{
				if(tick > 0){ 
				try { 
					Thread.sleep(200); 
				
				} catch (InterruptedException e) {
					
				}
				System.out.println(Thread.currentThread().getName() + " 完成售票，余票为：" + --tick); }
			}finally{ 
				lock.unlock();
				//释放锁 
			}
		}
	}
}