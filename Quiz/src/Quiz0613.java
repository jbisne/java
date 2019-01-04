public class Quiz0613 {

	public static void main(String[] args) {
		
		for (int i=1; i<10; i++) { //구구단나오면 for문 바로 생각!
			for (int j=2; j<10; j++) {
				System.out.printf("%d*%d=%d\t", j, i, i*j);
				// \t는 출력할때 Tab한 효과
				
			}
			System.out.println();
		}
		
		System.out.println("-----------");
		
		for (int i=2; i<10; i++) { //구구단나오면 for문 바로 생각!
			for (int j=1; j<10; j++) {
				System.out.printf("%d*%d=%d\t", i, j, i*j);
				// \t는 출력할때 Tab한 효과
				
			}
			System.out.println();
		}
	}

}
//끝낫고 여기서 가로 세로 입력하고 꾸미면 끝.