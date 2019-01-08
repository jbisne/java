//수업에서 푼 방법 2
import java.util.Random;

public class QuizRandom_3 {

	public static void main(String[] args) {
		Random rand = new Random();
		
		while(true) {
			int num1 = rand.nextInt(10); // 0~9
			int num2 = rand.nextInt(10); // 0~9
			int num3 = rand.nextInt(10); // 0~9
		
		
			if (num1 !=0 && num1 != num2 && num1 != num3 && num2 != num3) {
			System.out.println(num1 + "" + num2 + "" + num3);
			break;
			}
		}
	}

}
/*int num1 = rand.nextInt(10);쓰고 밑에 num1 != 0 을 달아주느냐
  int num1 = rand.nextInt(9) + 1; 를 처음부터 달아주느냐 선택 */
