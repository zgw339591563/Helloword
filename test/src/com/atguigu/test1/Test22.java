package com.atguigu.test1;

public class Test22 {

	public static void main(String[] args) {
		TestLock testLock = new TestLock();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 21; i++) {
					testLock.sell();
				}

			}
		}, "1号串口").start();

		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 21; i++) {
					testLock.sell();
				}

			}
		}, "2号串口").start();

		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 21; i++) {
					testLock.sell();
				}

			}
		}, "3号串口").start();
	}
}
