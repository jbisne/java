class Car {
	int 연료량;
	int 속도;
	
	Car() {
		연료량 = 10;
		속도 = 10;
	}
	void 엑셀레이터( ) {
		속도 = 속도 + 1;
		연료량 = 연료량 - 1;
	}
	
	void 브레이크() {
		속도 = 속도 - 1;
	}
	void 상태 () {
		System.out.println("연료량" + 연료량);
		System.out.println("속도 " + 속도);
	
	}
}

public class MyExample_02 {

	public static void main(String[] args) {
		Car myCar1 = new Car ();
		myCar1.상태();
	}
		myCar1.엑셀레이터();
		myCar1.엑셀레이터();
		myCar1.상ㅇㅇ;