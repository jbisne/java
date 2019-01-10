package chapter06;
import java.util.Scanner;

public class Quiz0612_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 개의 숫자를 입력하세요.");
		
		System.out.println("첫 번째 숫자 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.println("두 번째 숫자 입력 : ");
		int num2 = sc.nextInt();
		
		int nSum = 0;
		
		if (num1 < num2) {
			for (int i=num1; i <=num2; i++) {
				nSum = nSum + i;
				if (i < num2 )	{
					System.out.print(i + "+");
				} else {
					System.out.print(i + "=");
				}
			}
				
		} else {
			for (int i = num1; i >=num2; i--) {
				nSum = nSum + i;
				if ( i > num2) {
					System.out.print(i + "+");
				} else {
					System.out.print(i + "=");
				}
			}
		}

		System.out.print(nSum);
	}

}
