package Game;

import java.util.Random;
import java.util.Scanner;

public class QuizBaseball {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int com1, com2, com3;
		int user1, user2, user3;
		
		//while문 안에서 int num1 이러면 while문 안에서밖에 못쓰는수이기
		//때문에 밖에다 써주는것.
		
		
		while(true) {
			 com1 = rand.nextInt(9); // 0~9
			 com2 = rand.nextInt(9); // 0~9
			 com3 = rand.nextInt(9); // 0~9
			 
			 if ()
			 
		//여기서부터 반복
			 System.out.println("세자리 숫자를 입력하시오.");
			 int nInput = sc.nextInt();
			 user1 = nInput / 100;
			 user2 = (nInput - user1 * 100) /10;
			 user3 = (nInput -user1 * 100 - user2 * 10);
			 System.out.println(user1+":"+user2+":"+user3 );
			 
			 

	}

}
