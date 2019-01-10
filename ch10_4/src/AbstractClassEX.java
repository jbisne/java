abstract class Animal	{
	int age;
	abstract void cry();
	
}

//추상 클래스를 상속받으면 하위 클래스에서 구현을 해야한다. 라는 뜻의 예제.

class Dog extends Animal {
	void cry() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal {
	void cry() {
		System.out.println("야옹");
	}
}
public class AbstractClassEX {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.cry();
		
		Cat cat = new Cat();
		cat.cry();
	}
}
