package Game;
import java.util.Random;
import java.util.Scanner;

public class QuizLowHigh {

	public static void main(String[] args) {
		
		System.out.println("0부터 100 사이의 값 중에 하나를 생각하세요.");
		System.out.println("제(컴)가 제시한 숫자가 생각한 숫자보다 크면 h를 입력하세요.");
		System.out.println("제(컴)가 제시한 숫자가 생각한 숫자보다 작으면 l를 입력하세요.");
		System.out.println("제(컴)가 숫자를 맞췄다면 y를 입력해 주세요.");
		
		Scanner sc = new Scanner(System.in);
		
		Random rand = new Random();
		
		while(true) {
			
			int com = rand.nextInt(101);
			
			System.out.println("\n당신이 생각한 숫자는 " + com + "입니까?");
			
			int user = sc.nextInt();
			
			
			//핵심은 미니멈과 맥시멈 더해서 2로나누는값을 계속 물어보는것.
			//그래서 25 50 75같은 수가아닌이상 한번에 맞추진못함.
			// [질문] 그냥 계속 랜덤으로 물어보게해서 맞추게하는방법은??
			//->결국은 미니멈,맥시멈값 더해서 나눈값을 랜덤을 뽑아야함.
			// 랜덤으로 계속 물어보게 짜보자.
			
			
			
			
			
		}
	}
}



