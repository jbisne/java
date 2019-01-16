package chapter13;

import java.util.Scanner;

public class Quiz1308 {

	public static void main(String[] args) {
		//[과목][사람]
		int[][] score = new int[4][4];
		
		Scanner sc = new Scanner(System.in);
		// i 0:국어 1:영어 2:수학 3.국사
		// j 0:이순신 1:강감찬 2:을지문덕 3:권율
		
		for (int i=0; i<4; i++) {
				 if (i==0) System.out.print("국어점수 입력\n");
			else if (i==1) System.out.print("영어점수 입력\n");
			else if (i==2) System.out.print("수학점수 입력\n");
			else 		   System.out.print("국사점수 입력\n");
			
			for (int j=0; j<4; j++) {
				score[i][j] = sc.nextInt();			
				}
		}
		String s1 = "구분\t이순신\t강감찬\t을지문\t권율\t총점";
		System.out.println(s1);
		
		for (int i=0; i<4; i++) {
				 if (i==0) System.out.print("국어\t");
			else if (i==1) System.out.print("영어\t");
			else if (i==2) System.out.print("수학\t");
			else 		   System.out.print("국사\t");
				 
				 int sum = 0;
				 for (int j=0; j<4; j++) {
					 System.out.print(score[i][j] + "\t");
					 sum = sum +score[i][j];
				 }
			
				 System.out.print(sum);
				 System.out.println();
		}

	}

}
