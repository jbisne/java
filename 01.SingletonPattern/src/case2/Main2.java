package case2;

import java.time.LocalDateTime;
import java.util.Random;

public class Main2 {

	public static void main(String[] args) {
		
		Runnable task = () -> {
			try {
				Random rand = new Random();
				int n1 = rand.nextInt(100);
				Thread.sleep(n1);
				int n2 = rand.nextInt(100);
				//서로 틀린 로그값을 찍어보려고 해본것.
				//너무 빨리 돌리면 시드값이같아져 랜더값이 같을때가있다.
				
				LogWriter logger = LogWriter.getInstance();
				logger.log("***" + LocalDateTime.now() + ":" + n2 + "***");
			} catch (Exception e) {
			}
		};
		
		for (int i = 0; i < 50; i++) {
			Thread t = new Thread(task);
			t.start();
		}

	}

}
