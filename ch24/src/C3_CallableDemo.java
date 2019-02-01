import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class C3_CallableDemo {
	public static void main(String[] args) 
			throws InterruptedException, ExecutionException {
		
		Callable<Integer> task = () -> {
			int sum = 0;
			for (int i = 0; i < 10; i++)
				sum += i;
			return sum;
		};
		
		ExecutorService exr = Executors.newSingleThreadExecutor();
		Future<Integer> fur = exr.submit(task);
		
		Integer r = fur.get();
		System.out.println("result: " + r);
		exr.shutdown();
		
/*		Integer r2 = fur.get();
		System.out.println("result: " + r2);
		exr.shutdown();
 		이렇게 헷갈리면 확인 두번해주는 방법도있다.	*/
		

	}

}
// 쓰레드인것 같으면서 아닌것같은 방법.
// 계산 1개여서 쓰는게 이상해보이는데 10개등 여러개면 이거쓰긴한다.