package chapter07;
public class Quiz0703 {

	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 7;
		int num3 = 6;
		
		//여기서 int num = 수들은 로직다짜고 맞는지 임의로 설정한것.
		//맨 마지막에 숫자를 대입해보는것.
		int result = getMinNumber(num1, num2, num3);
		System.out.println("가장 작은 수 : " + result);

	}

	public static int getMinNumber (int num1, int num2, int num3) {
		int min = num1;
		if (min > num2) {
			min = num2;
		}
		if (min > num3) {
			min =num3;
		}
		return min;
	}
	
}