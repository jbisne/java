package chapter06;
import java.util.Scanner;

public class Quiz0610 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 5개 입력하세요.");
		
		int i = 0;
		int num;
		int nSum = 0;
		while ( i < 5) {
			System.out.println("숫자 입력 : ");
			num = sc.nextInt();
			if (num < 1) {
				System.out.println("숫자가 작습니다. 재입력해주세요.");
				continue;
			}
			nSum = nSum + num;
			i++;
		}
		
		System.out.println("합 : " + nSum);
		
	}

}
