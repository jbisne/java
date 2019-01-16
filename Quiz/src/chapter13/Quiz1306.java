package chapter13;
class Quiz1306 {
	public static void main(String[] args) {
		int[][] arr = {
			{2*1, 2*2, 2*3, 2*4, 2*5, 2*6, 2*7, 2*8, 2*9},
			{3*1, 3*2, 3*3, 3*4, 3*5, 3*6, 3*7, 3*8, 3*9},
			{4*1, 4*2, 4*3, 4*4, 4*5, 4*6, 4*7, 4*8, 4*9},
			
		};

		// 배열의 구조대로 내용 출력
		for(int i =0; i < arr.length; i++) {
			for (int j = 0; j< arr[i].length; j++) {
				System.out.print((i+2) + " * " + (j+1) + " = " + arr[i][j] + "\t");
			}
			System.out.println();		
		}
	}
}
// 예제보고 푼 첫번째 방법. 수업에서 배운건 두번째 방법.