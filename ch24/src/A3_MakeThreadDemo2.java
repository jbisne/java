class A3_MakeThreadDemo2 {
	public static void main(String[] args) 
	{
		
		Runnable task = () -> {
			try {
				Thread.sleep(3000); // ->3000동안 쉬어라 라는뜻.
			} catch (Exception e) {
			}
			
			int n1 = 10;
			int n2 = 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + ": " + (n1 + n2));
			
		};
		
		Thread t = new Thread(task); //쓰레드에다 만들어진 task를 넣는다.
		
		t.start();
		
		System.out.println("End " + Thread.currentThread().getName());
	}

}
