/*문제1
길이가 5인 int형 배열을 선언해서 사용자로부터 5개의 정수를 입력받는다.	
그리고 최대값, 최소값, 모든 수의 합을 구하라. 
함수(최대,최소,합)를 정의하여 구현하시오. */

package chapter13;
import java.util.Scanner;

class Quiz13_1 {
	public static void main(String[] args) {
		
		//길이가 5인 int형 배열 선언
		int[] ar1 = new int[5];
		
		System.out.println("5개의 숫자를 입력하시오.");
		Scanner sc = new Scanner(System.in);
		
		ar1[0] = sc.nextInt();
		ar1[1] = sc.nextInt();
		ar1[2] = sc.nextInt();
		ar1[3] = sc.nextInt();
		ar1[4] = sc.nextInt();
		// 요기 [] 인덱스는 0부터 시작하니까 주의.
		
		int sum = 0;
		
		//배열 요소의 전체 합 출력
		for (int e: ar1) {
			sum += e;
		}
		
		System.out.println("sum :" + sum); 
		
		/////(총합)/////
		
		public static int getMaxNumber (ar1[]) {
			int max = ar1[0];
			if (ar1[0] < ar1[1]) {
				max = ar1[0];
			}
			if (max < num3) {
				max =num3;
			}
			return max;
		
	}
}
