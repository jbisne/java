import java.util.Random;
import java.util.Scanner;

public class HighLow {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Random rand = new Random();
		
		while (true) {
			//갯수(횟수)가 정해진 조건은 for문이 사용하기좋다.
			System.out.println("나는 지금 0부터 100사이의 값 중에 하나를 생각하겠습니다.");
			System.out.println("당신은 그 숫자를 6회안에 맞추시면 됩니다.");
			
			int com = rand.nextInt(101);
			
			for(int i=0; i<6; i++) {
				int user = sc.nextInt();
				
				if (com < user) System.out.println(user + "는 제가 정한 숫자보다 큽니다.");
				if (com > user) System.out.println(user + "는 제가 정한 숫자보다 작습니다.");
				if (com ==user) {
					System.out.println(user + "정답입니다.");
					break;
					/*
				 	 if (com < user) System.out.println(user + "는 제가 정한 숫자보다 큽니다.");
				else if (com > user) System.out.println(user + "는 제가 정한 숫자보다 작습니다.");
				else if (com ==user) {
				이렇게 해도되긴한다. */
				}
				if (i<5)
					System.out.println( (6 - i - 1) + "회 남았습니다.");
				else
					System.out.println("모든 기회를 다 사용했습니다.");
			}
			
			System.out.println("게임을 더 진행하시겠습니가? (y/n)");
			String str = sc.next();
			if (!str.equalsIgnoreCase("y")) {
				System.out.println("Good bye~");
				break;
			}
		}

	}

}
