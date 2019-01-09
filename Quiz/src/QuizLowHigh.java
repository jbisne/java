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
			
			
			//h를 입력한다면 -> com은 더 작은수를 출력
			//l을 입력한다면 -> com 은 더 큰수를 출력
			//h입력은 어떻게??
			
			
			
		}
	}
}



