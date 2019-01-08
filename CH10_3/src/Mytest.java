abstract class Animal	{
	int age;
	abstract void cry();
	void wlk() {}	
	void run() {}
}

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
public class Mytest {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.cry();
		
		Cat cat = new Cat();
		cat.cry();
	}
}
