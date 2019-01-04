public class Quiz0604 {

	public static void main(String[] args) {
		int num = 1;	//우선 맨 위에 변수값 지정.
		int result = 0;
		
		do {
			result = result + (num);
			if ( num == 1000)
				System.out.printf(" %d = %d", num, result);
			else
				System.out.printf(" %d + ", num );
			num++;
		} while (num <= 1000);
	}
}