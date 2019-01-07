class 거인 {
	String name;
	String 체형;	// 큰넘, 작은넘, 뚱뚱한넘, 마른넘
	String 타입;	// 남성형, 여성형
	int 키;
	//------------필드, 멤버 변수----------//
	
	거인() {
		name = "작은애";
	}
	거인(String str) {
		name = str;
	}
	void 걷기() {
		System.out.println(name + "걷기");
	}
	void 뛰기 () {
		System.out.println(name + " 뛰기");
	}
	void 공격 () {
		System.out.println(name + " 공격");
	}
	//-----------메서드, 멤버 함수--------//
}


public class MyExample {

	public static void main(String[] args) {
		거인 aaa1 = new 거인();
		aaa1.걷기();
		
		거인 aaa2 = new 거인("홍길동");
				aaa2.걷기();
	}

}
