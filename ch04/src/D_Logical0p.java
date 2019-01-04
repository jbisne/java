
public class D_Logical0p {

	public static void main(String[] args) {
		int num1 = 11;
		int num2 = 22;
		boolean result;
		
		result = (1 < num1) && (num1 < 100);
		System.out.println("1 초과 100 미만인가? " + result);
		
		result = ((num2 % 2) == 0) ||((num2 % 3) == 0);
		System.out.println("2또는 3의 배수인가? " + result);
		
		result = ! (num1 != 0);
		System.out.println("(결과적으로) 참이 아니다." + result);
		
	}

}
