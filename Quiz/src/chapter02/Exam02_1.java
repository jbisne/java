package chapter02;
import java.util.Scanner;

public class Exam02_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 개의 숫자를 입력하세요.");
		
		System.out.println("첫 번째 숫자 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.println("두 번째 숫자 입력 : ");
		int num2 = sc.nextInt();
		
		int result2 = num1 - num2;
		int result3 = num1 * num2;
		int result4 = num1 / num2;
		
		System.out.printf("%d 더하기 %d 는 %d \n", num1, num2, num1 + num2 );
		System.out.println("빼기 :" + result2);
		System.out.println("곱하기 :" + result3);
		System.out.println("나누기 :" + result4);
	}

}
