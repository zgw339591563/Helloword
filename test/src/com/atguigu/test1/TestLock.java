package com.atguigu.test1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
	private int ticket = 20;
	private Lock lock = new ReentrantLock();

	public void sell() {
		
		try {
			lock.lock();
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "正在卖第" + (ticket--) + "张票,还剩" + ticket + "张票");

			}
		} catch (Exception e) {

		} finally {
			lock.unlock();
		}
	}
}
