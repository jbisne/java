package chapter07;
/*
섭씨(Celsius)를 입력받아서 화씨(Fahrenheit)로 변환하여 리턴하는 함수와
화씨를 입력받아서 섭씨로 변환하여 리턴하는 함수를 만들어라.
화씨 = 1.8 * 섭씨 + 32
섭씨 = (화씨 - 32) / 1.8
*/

public class Quiz0704 {

	public static void main(String[] args) {
		double num = 30.0;
		//여기서 30.0은 로직 다 짜고 수 대입해서 맞는지 실험해보는 수.
		//맨 마지막에 숫자 대입해보는것.
		System.out.println("기준 값 " + num);
		
		double result1 = CelconvFah(num);
		System.out.println("화씨 : " + result1);
		
		double result2 = FahConvCel(result1);
		System.out.println("섭씨 : " + result2);

	}

	public static double CelconvFah(double num) {
		//화씨 = 1.8 * 섭씨 + 32
		return (1.8 * num +32);
		/*double result = 1.8 * num + 32;
		return result; 이렇게 써도 되는걸 요약해준것.*/
	}
	
	public static double FahConvCel(double num) {
		//섭씨 = (화씨 -32) / 1.8
		
		return((num-32)/1.8);
	}
}
