package Game;
//수업에서 푼 방법1
import java.util.Random;

public class QuizRandom_2 {

	public static void main(String[] args) {
		Random rand = new Random();
		//100~999인데  서로다르게 나와야하니까
		//102~987
		
		while (true) {
			int num = rand.nextInt(1000); //0~999
			if (num < 102 ) {
				continue;
			}
			int num1 = num / 100; //몫이 9
			int numT = num - num1 * 100; //87
			int num2 = numT / 10; // 8
			int num3 = numT % 10;
			if (num != num2 && num1 != num3 && num2 != num3) {
				System.out.println(num1 + "" + num2 + "" + num3);
				break;
			}
		}
	}

}
