package com.atguigu.test1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TesttwotHREAD {

	public static void main(String[] args) {
		Mydata mydata = new Mydata();
		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10; i++) {
					try {
						mydata.incr();
					} catch (Exception e) {
						
						e.printStackTrace();
					}
				}
			}
		}, "加法线程1").start();

		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10; i++) {
					try {
						mydata.decr();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, "减法线程1").start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10; i++) {
					try {
						mydata.incr();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, "加法线程2").start();

		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10; i++) {
					try {
						mydata.decr();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, "减法线程2").start();
		

	}
}

class Mydata {

	private int number = 0;

	public synchronized void incr() throws Exception {
		
		while(number==1){
			wait();
		}
		
		try {
			
			
			number++;
			System.out.println(Thread.currentThread().getName()+"：numer值为:"+number+"在做加法");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			this.notifyAll();
		}
	}

	public synchronized void decr() throws Exception {
		
		while(number==0){
			wait();
		}
		
		try {
			
			number--;
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+"：numer值为:"+number+"在做减法");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			this.notifyAll();
		}
	}
}
