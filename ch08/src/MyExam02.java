public class MyExam02 {

	public static void main(String[] args) {
	//이 구문은 동작을 정하는것.
	//재료를 줄것이냐 ->2가지 형태 (Add 1,3)
	//결과를 받을것이냐 -> 2가지형태 (Add2,4) 해서 총 4가지 형태.
		
		Add1();
		int nResult = Add2();
		Add3(10, 20);
		int nResult2 = Add4(1, 2);

	}
	public static void Add1() {
		System.out.println(1+2);
		//그냥 출력하는 것. 매개변수, 리턴값 X
	}
	
	public static int Add2() {
		return (1+2);
		
		//반환값(인트,스트링,더블 등) 있으면 리턴을받아야함.
		//add2부르면 "3"을 받는것.
	}	
	
	public static void Add3(int num1, int num2) {
			System.out.println(num1 + num2);
	}
		
	public static  int Add4(int num1, int num2) {
			return (num1 + num2);
			
	}
}
