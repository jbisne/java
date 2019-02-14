import java.util.Scanner;

public class ThreadMain 
{
	
	// (디폴트)생성자 (없어도 된다)
	public ThreadMain() {
		
	}
	
	public void init()
	{
		System.out.println("숫자를 입력해 주세요.");
		Scanner s = new Scanner(System.in);
		String s_num = s.nextLine();
		int n_num = Integer.parseInt(s_num);
		
		try {
			Thread tsub = new ThreadSub(n_num);
			tsub.start();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("이름을 입력해 주세요.");
		String s_name = s.nextLine();
	}

	public static void main(String[] args) 
	{
		// 객체 생성
		ThreadMain tm = new ThreadMain();
		// 자기자신을 new로 만들어준것.
		tm.init();
	}
	///////////////////////내부 클래스////////////////////////
	
	static public class ThreadSub extends Thread 
	{
		int nNum;

		public ThreadSub(int num)
		{
			this.nNum = num;
		}
		
		//run()메소드 재정의
		@Override
		public void run() 
		{
			int i = 0;
			while ( i < nNum) {
				try {
					Thread.sleep(1000);
					i = i + 1;
					System.out.println("Thread : " + i);
				
				} catch(Exception e) {
					System.out.println("예외 : " +e);
				}
			}
		}
	}	
}