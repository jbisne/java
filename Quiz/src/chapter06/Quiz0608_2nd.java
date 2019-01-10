package chapter06;
public class Quiz0608_2nd {

	public static void main(String[] args) {
		//구구단 출력하라->for문 2개 바로 생각.
		//nMax, mSum등은 그냥 자기 편한대로 적는 문구.
		
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