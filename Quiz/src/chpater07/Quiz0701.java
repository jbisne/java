package chpater07;
// (문제1) 세 개의 정수를 인자로 전달 받아서 평균을 반환하는 함수를 정의하라

import java.util.Scanner;

public class Quiz0701 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 숫자 : ");
		int num1 = sc.nextInt();
		
		System.out.println("두번째 숫자 : ");
		int num2 = sc.nextInt();
		
		System.out.println("세번째 숫자 : ");
		int num3 = sc.nextInt();
		
		int avg = returnavg(num1, num2, num3);
		//avg, returnavg 전부 내가 편한대로 임의로 정한 단어.

		System.out.printf("평균은 : %d \n" , avg);
		//System.out.println("평균은 : " + returnavg(num1, num2, num3));
	}
	
	public static int returnavg(int num1, int num2, int num3) {
		return (num1 + num2 + num3) / 3;
	}
}
