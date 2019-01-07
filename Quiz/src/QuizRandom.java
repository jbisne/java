/*랜덤한 세자리 수를 표시합니다.
단 100의 자리와 수와 10의 자리의 수 1의 자리의 수는 같아서는 안됩니다.*/
import java.util.Random;

public class QuizRandom {

	public static void main(String[] args) {		
		
		Random rand = new Random();
		int num1 = rand.nextInt(9)+1;
		int num2 = rand.nextInt(9);
		int num3 = rand.nextInt(9);
		
		System.out.printf("%d%d%d",num1, num2, num3);

	}

}
//while if break 문 섞기.