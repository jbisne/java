public class Quiz0608_2nd {

	public static void main(String[] args) {
		//짝수 구구단만 출력하라->for문 2개면 된다.
		
		for (int i=2; i<10; i=i+2 ) {
			int nMax = i;
			for (int j=1; j<=nMax; j++) {
				System.out.printf("%d * %d = %d\t", i, j, i*j);
			}
			System.out.println();
		}

	}

}
//이게 두번째 방법