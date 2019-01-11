package chapter07;
public class Quiz0701_2 {

	public static void main(String[] args) {
		double result = getAverage(3, 5, 7);
		System.out.println("평균 : " + result);
	}
	
	public static double getAverage(int num1, int num2, int num3) {
		
		int sum = num1 + num2 + num3;
		double avg = (double)sum / 3;
		return avg;
		//double이 쓰인이유는 평균구할때 나누면 소숫점까지 나올수있기때문.
	}

}
