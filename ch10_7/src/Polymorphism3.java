//요 부분이 디자인 패턴 가장 기본적이고 많이 보일 패턴.

abstract class Human {
	abstract void print();
}

class Man extends Human {
	void print () {
		System.out.println("남자 생성");
	}
}

class Woman extends Human {
	void print() {
		System.out.println("여자 생성");
	}
}

public class Polymorphism3 {
	
	public static Human humanCreate(int kind) {
		if (kind == 1) {
			return new Man();
			//Human m = new Man();
			//return m; 이렇게 두줄 쓴거랑 같음.
		} else {
			return new Woman();
			//Human w = new Woman();
			//return w; 이렇게 두줄 쓴거랑 같음.
		}
	}

	public static void main(String[] args) {
		//생성된 애가 남자인지 여자인지 중요하지않고
		//난 생성된 인간 객체의 프린트 기능만 쓸 것이다.
		//남자이면 남자애가 가진 기능을 할 것이고,
		//여자이면 여자애가 가진 기능을 할 것이다.
		Human h1 = humanCreate(1);
		h1.print();
		
		Human h2 = humanCreate(2);
		h2.print();

	}

}
