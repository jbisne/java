import java.util.Scanner;

public class Quiz0606 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇 개의 수를 입력하시겠습니까? : ");
		int nMax = sc.nextInt();
		double nSum = 0.0;
		
		//끝이 정해져있는 조건문은 for문을 쓰는게좋다. (아직 배운건 for, while 두개뿐)
		
		for (int i=0; i<nMax; i++) {
			int num = sc.nextInt();
			nSum = nSum + num;
		}
		double nAvg = nSum / nMax;
		
		System.out.println("평균은 : " + nAvg);
	}

}
