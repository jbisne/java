package chapter13;
class Quiz1306 {
	public static void main(String[] args) {
		int[][] arr = {
			{21, 22, 23, 24, 25, 26, 27, 28, 29},
			{31, 32, 33, 34, 35, 36, 37, 38, 39},
			{41, 42, 43, 44, 45, 46, 47, 48, 49},
			
		};

		// 배열의 구조대로 내용 출력
		for(int i =0; i < arr.length; i++) {
			for (int j = 0; j< arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		
		}
	}
}
