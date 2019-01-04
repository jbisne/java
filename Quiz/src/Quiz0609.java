import java.util.Scanner;

public class Quiz0609 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		//~를 출력하시오. 문제는 전부 이렇게 시작.
		
		for (int i=9; i>=1; i-- ) {
			System.out.printf("%d * %d = %d \n", num, i, i * num);
		}

	}

}
