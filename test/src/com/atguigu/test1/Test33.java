package com.atguigu.test1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test33 {

	public static void main(String[] args) {
		As as = new As();
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					as.t1();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					as.t2();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();
	}
}

class As {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void t1() throws Exception {
		lock.lock();
		try {
			for (int i = 1; i <= 52; i++) {

				System.out.println(Thread.currentThread().getName() + "\t" + i);
				if (i % 2 == 0) {
					condition.signalAll();
					condition.await();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void t2() throws Exception {

		lock.lock();
		try {
			for (int i = 0; i < 26; i++) {

				System.out.println(Thread.currentThread().getName() + "\t" + (char)(i+'A'));
				condition.signalAll();
				condition.await();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}