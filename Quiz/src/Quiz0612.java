import java.util.Scanner;

public class Quiz0612 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = 1;
		int result = 0;
		
		System.out.println("첫번째 숫자 입력 : ");
		int num1 = sc.nextInt();
		//~를 출력하시오. 문제는 전부 이렇게 시작.
		
		System.out.println("두번째 숫자 입력 : ");
		int num2 = sc.nextInt();
		
		do {
			result = result + (num);
			if (num == result)
				System.out.printf(" %d == %d", num, result);
			else
				System.out.printf(" %d + ", num );
			num++;
		}while (num < result);
	}

}
//i j 순서, 앞뒤 바꾸기.