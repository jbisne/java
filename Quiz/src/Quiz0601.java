import java.util.Scanner;

public class Quiz0601 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		//자동차 시동키라고 생각. '입력'해야한다싶으면 바로 이것 쓰기.
		
		System.out.println("두 개의 숫자를 입력하세요.");
		
		System.out.println("첫 번째 숫자 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.println("두 번째 숫자 입력 : ");
		int num2 = sc.nextInt();
		
		//위처럼 친절히 사용법적는게 UI(유저 인터페이스)
		
		int nDiff = num1 - num2;
		if (nDiff < 0)
			nDiff = nDiff * -1;
		
		System.out.println("두 수의 차는 " + nDiff);
		
		sc.close();
	}

}
