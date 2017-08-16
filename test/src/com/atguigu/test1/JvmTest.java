package com.atguigu.test1;

import java.util.Random;

public class JvmTest {

	public static void main(String[] args) {
		
		System.out.println("虚拟机最大内存："+(Runtime.getRuntime().maxMemory())/(double)1024/1024+"MB");
		System.out.println("虚拟机总内存："+(Runtime.getRuntime().totalMemory())/(double)1024/1024+"MB");
		String str = "www.atguigu.com" ;
		while(true) 
		{
		str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999) ;
		}

	}
}
