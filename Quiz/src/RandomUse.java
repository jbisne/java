import java.util.Random;

public class RandomUse {

	public static void main(String[] args) {
		
		//Type #1
		Random randomV1 = new Random();
		
		System.out.println(randomV1.nextBoolean());
		System.out.println(randomV1.nextFloat());
		System.out.println(randomV1.nextInt());
		System.out.println(randomV1.nextInt(100)); // range : 0~99
		/*예를들어 50~99까지 수를 구하고싶다. nextInt(50) + 50 하면됨.
		 그러면 nextInt(50)-> 0~49를 구하고 거기에, 50 더해지니 50~99사이구함.
		 nextInt(100)은 0~99이기때문에 + 1을해줘야 1~100을 구한다.*/
		
		//Type #2 : 1~100 사이의 값 출력
		double randomV2 = Math.random();
		System.out.println("1 : " + randomV2);
		int intVal = (int)(randomV2 * 100) + 1;
		System.out.println("2 : " + intVal);
		
		// (int)(Math.random() * (최대값 - 최소값 +1)) + 최소


	}

}
