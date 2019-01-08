//랜덤 구할때 사용하는 공식.

import java.util.Random;

public class HowToRandom {

	public static void main(String[] args) 
	{
		Random rand = new Random();
		int num = rand.nextInt(100); //0~99
		
		System.out.println(num);

	}

}
