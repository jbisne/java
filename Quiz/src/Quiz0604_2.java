public class Quiz0604_2 {

	public static void main(String[] args) {
		
		int i = 1;
		int nSum = 0;
		int nMax = 10; //맨처음 nMax=10이렇게 테스트해보고 숫자를 100 1000으로 단계별로 늘림.
				
		do {
			if ( i < nMax ) {
				System.out.print(i + "+");
			} else {
				System.out.print(i + "=");
			}
			System.out.print(i + "+");
			nSum = nSum + i;
			i++;
			
		}while ( i<= nMax);
		
		System.out.print("합 : " + nSum);

	}

}
