package chpater07;
public class Quiz0702_2 {

	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 7;
		int num3 = 6;
		
		int result = getMaxNumber(num1, num2, num3);
		System.out.println("가장 큰 수 : " + result);

	}

	public static int getMaxNumber (int num1, int num2, int num3) {
		int max = num1;
		if (max < num2) {
			max = num2;
		}
		if (max < num3) {
			max =num3;
		}
		return max;
	}
	
}