package ch13;
//잘 모르겟으면 그림 그려가면서 해보면 쉽다.

class E1_TwoDimenArray {
	public static void main(String[] args) {
		int[][] arr = new int[3][4];
		
		int num = 1;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				arr[i][j] = num;
				num++;
			}
		}
		
		for(int i=0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(arr[i][j] + "\t");
			}
		
			System.out.println();
		}
	}
}
