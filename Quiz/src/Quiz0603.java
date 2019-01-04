import java.util.Scanner;

public class Quiz0603 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력 : ");
		int num = sc.nextInt();
		
		int nResult = 1;
		
		System.out.printf("%d! = ", num);
		// 3! = 3*2*1
		while (num >= 1) {
			
			if (num == 1) {
				System.out.println(num + " = ");
			} else {
			System.out.print(num + " * ");
			}
			nResult = nResult * num;
			
			num--;
		}
		
		System.out.println(nResult);
		
		sc.close();
		
		//처음부터 한번에 만드는게 아니라 결과보면서 조금씩 꾸며주면서 완성시키자.
	}

}
