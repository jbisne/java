package chapter06;
import java.util.Scanner;

public class Exam06_02 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		int sum = (num1 + num2 + num3) / 3;
		
		System.out.printf("(%d + %d +%d) / 3 = %d \n", num1, num2, num3, sum);
		
	if(sum >=  90)
		System.out.println("A");
	else if(sum >= 80)
		System.out.println("B");
	else if(sum >= 70)
		System.out.println("C");
	else if(sum >= 50)
		System.out.println("D");
	else
		System.out.println("F");
		}
}
