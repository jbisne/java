package chpater07;
import java.util.Scanner;

public class Quiz0702 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 숫자 : ");
		int num1 = sc.nextInt();
		
		System.out.println("두번째 숫자 : ");
		int num2 = sc.nextInt();
		
		System.out.println("세번째 숫자 : ");
		int num3 = sc.nextInt();
		
		// num1이 num2보다 클 조건 -> num1>num2 or num1 - num2 >0 
	
		if( num1 > num2) {
			System.out.println(num1);
		}
	}
}