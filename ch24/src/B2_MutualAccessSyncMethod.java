class Counter2 {
	int count = 0;
	
	synchronized public void increment() {
		count++;
	}
	
	synchronized public void decrement() {
		count--;
	}
	
	public int getCount() { return count; }
}

class B2_MutualAccessSyncMethod {
	public static Counter2 cnt = new Counter2();
	
	public static void main(String[] args)
			throws InterruptedException
	{
		
		Runnable task1 = () -> {
			for(int i = 0; i<1000; i++)
				cnt.increment();
		};
		
		Runnable task2 = () -> {
			for(int i = 0; i<1000; i++)
				cnt.decrement();
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		
		t1.start();
		t2.start();
		
		t1.join();	
		t2.join();	
		
		
		System.out.println(cnt.getCount());
	}
}
// class의 변수를 자유롭게 쓸수잇다는 [장점]이 있지만
// synchronized 때문에 속도가 현저하게 느려진다는 [단점]이있다.
