
enum Person4 {
	MAN, WOMAN;

	@Override
	public String toString() {
		return "I am a cat person";
	}
}

public class B2_EnumConst {
	public static void main(String[] args) {	
		System.out.println(Person4.MAN);	//toString 메서드의 반환 값 출력
		System.out.println(Person4.WOMAN);
	}

}

//앞의 예제를 보면 '열거형 값'이 해당 자료형의 인스턴스라는 사실을 알려준다.

//모든 열거형은 java.lang.Enum<E>클래스를 상속한다.
//그리고 Enum<E>는 Object클래스를 상속한다.
//이런 측면에서 볼 때 열거형은 클래스이다.