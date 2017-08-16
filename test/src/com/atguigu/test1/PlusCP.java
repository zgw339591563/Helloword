package com.atguigu.test1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PlusCP {

	public static void main(String[] args) {
		BB bb = new BB();
		new Thread(new Runnable() {

			public void run() {
				for (int i = 1; i <= 10; i++) {
					try {
						bb.A(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}, "A").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					try {
						bb.B(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}, "B").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					try {
						bb.C(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}, "C").start();

	}
}

class BB {
	private int num = 0;
	private int flag = 1;
	Lock lock = new ReentrantLock();
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();
	Condition condition3 = lock.newCondition();

	public void A(int loopnum){

		lock.lock();
		try {
			while (flag != 1) {
				condition1.await();
			}
			for(int i=1;i<=5;i++){
				System.out.println(Thread.currentThread().getName() + "----"+i+"----循环次数" + loopnum);
			}
			
			flag = 2;
			condition2.signal();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			lock.unlock();
		}

	}

	public void B(int loopnum) throws Exception {
		lock.lock();
		try {
			while (flag != 2) {
				condition2.await();
			}
			for(int i=1;i<=10;i++){
				System.out.println(Thread.currentThread().getName() + "----"+i+"----循环次数" + loopnum);
			}
			
			flag = 3;
			condition3.signal();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

	public void C(int loopnum) throws Exception {
		lock.lock();
		try {
			while (flag != 3) {
				condition3.await();
			}
			for(int i=1;i<=15;i++){
				System.out.println(Thread.currentThread().getName() + "----"+i+"----循环次数" + loopnum);
			}
			flag = 1;
			condition1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}