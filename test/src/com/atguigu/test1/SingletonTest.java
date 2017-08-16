package com.atguigu.test1;

public class SingletonTest {

	private static SingletonTest s;
	
	public synchronized static SingletonTest getSingletonTest(){
		
		if(s==null){
			return new SingletonTest();
		}
		
		return s;
	}
}
