package chapter13;

import java.util.Scanner;

public class Quiz14_4 {

	public static void main(String[] args) {
		int[] arr = new int [10];
		//10개가 선언된것.
		// arr[0]= 0; arr[9]= 0;
				
		Scanner sc = new Scanner(System.in);
		int n1 = 0;
		int n2 = arr.length - 1;
		
		
		for (int i=0; i<arr.length; i++) {
			
			int  nTmp = sc.nextInt();
			if( (nTmp % 2) == 0) {
				arr[n2] = nTmp;
				n2 = n2 -1;
			
			} else {
			arr[n1] = nTmp;
			n1 = n1 + 1;
			}
//홀수면 0에서 더해가면됨.
		}
	}
}