package chapter13;

public class Quiz1306_2 {

	public static void main(String[] args) {
		
		int[][] num = new int[3][9];
		for (int i=0; i<3; i++) {
			for(int j=0; j<9; j++) {
				num[i][j] = (i+2) * (j+1);
			}
		}
		
		for (int i=0; i<num.length; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(num[i][j] + " "+"\t");
			}
			System.out.println();
		}
	}
}
