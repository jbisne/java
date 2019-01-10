package chpater07;
/*메서드 4개만드는거였는데, swtich문으로 하나로만듬. 원래대로 하려면
  switch문을 위로 올려야함.
 */
import java.util.Scanner;

public class Quiz0705 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("세 개의 숫자를 입력하세요.");
		
		while (true) {
			System.out.println("첫번째 숫자 : ");
			int num1 = sc.nextInt();
		
			System.out.println("두번째 숫자 : ");
			int num2 = sc.nextInt();
		
			System.out.println("(1:더하기 2:빼기 3:곱하기 4:나누기)	: ");
			int num3 = sc.nextInt();
	
			//정수만 입력했다고 가정
			if (num3 >= 1 && num3 <= 4) {
				// 메서드 호출하고
				Calc(num1, num2, num3);
				// while 종료
				break;
			}
		}
	}
	
		public static void Calc(int num1, int num2,	int num3) {
		//출력할거없으니 void, 계산할거니까 Calc라고 명명.
		switch (num3) { 
		case 1: // 더하기
			System.out.printf("%d + %d = %d \n", num1, num2, num1 + num2);
			break;
		case 2: // 빼기
			System.out.printf("%d - %d = %d \n", num1, num2, num1 - num2);
			break;
		case 3: // 곱하기 
			System.out.printf("%d * %d = %d \n", num1, num2, num1 * num2);
			break;
		case 4: // 나누기
			System.out.printf("%d / %d = %d \n", num1, num2, (double)num1 / num2);
			break; //(double)(num1/num2)할 필요없고 (double)num1 / num2 하면됨.
		default:
			break;
		
		}
	}
}