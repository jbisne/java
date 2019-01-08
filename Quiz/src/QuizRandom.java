/*랜덤한 세자리 수를 표시합니다.
단 100의 자리와 수와 10의 자리의 수 1의 자리의 수는 같아서는 안됩니다.
이 문제가 내가 한거 */
import java.util.Random;

public class QuizRandom {

	public static void main(String[] args) {		
		
		Random rand = new Random();
		while (true) {
			int num1 = rand.nextInt(9)+1;
			int num2 = rand.nextInt(10);
			int num3 = rand.nextInt(10);
	
		
			if(num1 != num2 && num1 != num3 && num2 != num3) {
			/*여기서 계속 틀렷던 이유가 { } 로 열고닫아줫어야 하는데, ;로 
			 문장을 끝내버렸기 때문(=즉,밑에 break로 가지 않았다.)*/
			System.out.printf("%d%d%d",num1, num2, num3);
			break;
			}
		}	

	}

}