package chapter06;
import java.util.Scanner;

public class Quiz0605 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int nInput; 	//입력 받은 수
		int nSum = 0;	//합
		while (true) {
			//입력받기
			System.out.print("숫자 입력 : ");
			nInput = sc.nextInt();
			
			//입력 받은 수 모두 더하기
			nSum = nSum + nInput;
			
			if (nInput == 0) {
				break;
			}
			
		}
		
		//결과 출력
		System.out.println("더한 값은 : ");
	}

}
