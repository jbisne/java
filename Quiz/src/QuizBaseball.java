import java.util.Random;
import java.util.Scanner;

public class QuizBaseball {

	public static void main(String[] args) 
	{
		System.out.println("숫자 야구 게임을 시작합니다.");
		
		Random rand = new Random();
		int a = rand.nextInt(9) + 1; 
		int b = rand.nextInt(9) + 1;
		int c = rand.nextInt(9) + 1;
		
		if (a!=b && a!=c && b!=c) {
			System.out.println();
		}
		
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt(); 
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		System.out.println(num1 + "," + num2 + "," + num3);

		
			if (a == num1) {
				System.out.println("strike");
			}
			else if (a == num2 && a == num3) {
				System.out.println("ball");	
			}
		
			if (b == num2) {
				System.out.println("strike");
			}
			else if (b == num1 && a == num3) {
					System.out.println("ball");
			}
			if (c == num3) {
				System.out.println("strike");
			}
			else if (c == num1 && a == num2) {
				System.out.println("ball");
			}
			if (a!=num1 && a!=num2 && a!=num3 && b!=num1 && b!=num2 && b!=num3 && c!=num1 && c!=num2 && c!=num3) {
				System.out.println("OUT!");
			}
			if (a==num1 && b==num2 && c==num3) {
				System.out.println("정답입니다.");
			}
	
	}
}

