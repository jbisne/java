import java.util.Scanner;

public class Exam02_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 개의 숫자를 입력하세요.");
		
		System.out.println("첫 번째 숫자 입력 :");
		int num1 = sc.nextInt();
				
		System.out.println("두 번째 숫자 입력 : ");
		int num2 = sc.nextInt();
		
		int result1 = num1 / num2;
		int result2 = num1 % num2;
		
		System.out.printf("%d 나누기 %d의 몫은 %d 입니다.", num1, num2, result1);
		System.out.printf("%d 나누기 %d의 나머지는 %d 입니다.", num1, num2, result2);
		
		sc.close();
	}

}
