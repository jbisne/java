package Game;
import java.util.Random;
import java.util.Scanner;

class QuizRPSGame {

	public static void main(String[] args) {
		int user;
		int com;
		
	
		Scanner s = new Scanner(System.in);
		Random rand = new Random();
		while (true) { //무제한 반복. 나갈 조건을 만들어줘야함.
			System.out.println("무엇을 내겠습니까? (1:가위 2:바위 3:보 0:종료) : ");
			
			user = s.nextInt();
			com = rand.nextInt(3) + 1;
			
			if (user ==0) {
				System.out.println("*** 게임을 종료합니다 **");
				break;
			}
		
			//============승부 판단 부분===============================
			if (user ==1 && com ==1) System.out.println("사용자 : 가위, 컴퓨터 : 가위/n 비겼습니다.");
		
			
			
			
			
			
			
			
			
		while (true) {
			System.out.println("무엇을 내겠습니까? (1:가위 2:바위 3:보 0:종료) : ");
		
		
	
	}

}
