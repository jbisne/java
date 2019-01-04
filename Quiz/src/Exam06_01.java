import java.util.Scanner;

public class Exam06_01 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int sum = num1 - num2;
		System.out.printf("%d - %d = %d \n", num1, num2, sum);
	}

}
//num1이 num2보다 작을수잇으니 num1이 큰수가되게 조건달기.
