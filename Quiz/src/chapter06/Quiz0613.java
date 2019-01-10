package chapter06;
public class Quiz0613 {

	public static void main(String[] args) {
		
		System.out.println("가로 \n");
		for (int i=1; i<10; i++) { //구구단나오면 for문 바로 생각!
			for (int j=2; j<10; j++) {
				System.out.printf("%dx%d=%d\t", j, i, i*j);
				// \t는 출력할때 Tab한 효과
				
			}
			System.out.println("\n");
		}
		
		System.out.println("세로 \n");
		
		for (int i=2; i<10; i++) { //구구단나오면 for문 바로 생각!
			for (int j=1; j<10; j++) {
				System.out.printf("%d*%d=%d\t", i, j, i*j);
				// \t는 출력할때 Tab한 효과
				
			}
			System.out.println("\n");
		}
	}

}