import java.util.Random;

public class LEVEL1_01 {
	public static void main(String[] args) {
		Random rand = new Random();
		
		
		int[] num = new int[rand.nextInt(100) + 1];
		System.out.println("배열의 길이 : " + num.length);
		
		for(int i=0; i < num.length; i++) {
			num[i] = i * 1 + 1;
			System.out.print(num[i] + " ");
		
		}
	
	}

}
