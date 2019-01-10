package chpapter02;
import java.util.Scanner;

public class Exam02_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("한 개의 숫자를 입력하세요.");
		
		System.out.println("숫자 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.println(num1 + "의 제곱은 " + num1 * num1 + " 이다.");
	}

}
