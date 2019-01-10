package chapter06;
public class Quiz06AZ {

	public static void main(String[] args) {
		// AZ + ZA = 99
		// A*10 + Z = 99
		// Z*10 + A =99

		for (int A=1; A<10; A++) {  //for문에서 10밑에구할때 이 식 많이씀.
			for (int Z=1; Z<10; Z++) { //for문에 int있으면 위에 변수값 입력안해도됨.
				if ( (A*10 + Z) + (Z*10+A) == 99 && (A != Z)) { //&&는 and라는 뜻.
					System.out.println((A*10+Z) + "+" + (Z*10+A));
				}
				
			
			}

		}

	}
}