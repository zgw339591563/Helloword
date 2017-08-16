package com.atguigu.test1;

public class Productandcomsumer {

	public static void main(String[] args) {
		AA aa = new  AA();
		new Thread(new Runnable(){
		public void run() {
			try {
				for(int i=1;i<=10;i++){
					aa.incre();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}, "生产者1").start();
		
		new Thread(new Runnable(){
			public void run() {
				try {
					for(int i=1;i<=10;i++){
						aa.decre();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "消费者1").start();
		
		new Thread(new Runnable(){
			public void run() {
				try {
					for(int i=1;i<=10;i++){
						aa.incre();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "生产者2").start();
			
			new Thread(new Runnable(){
				public void run() {
					try {
						for(int i=1;i<=10;i++){
							aa.decre();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, "消费者2").start();
	
}

}

class AA {
	
	
	private int number=0;
	
	public synchronized  void incre() throws Exception{
		while(number!=0){
			wait();
		}
		number++;
		System.out.println(Thread.currentThread().getName()+"----"+number);
		this.notifyAll();
	}
	
	
	public synchronized  void decre() throws Exception{
		while(number==0){
			wait();
		}
		number--;
		System.out.println(Thread.currentThread().getName()+"----"+number);
		this.notifyAll();
	}


	
}