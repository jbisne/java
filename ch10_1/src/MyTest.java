class Cat {
	static int a = 5;
	int num = 3;

	void Print(int num3) {
		System.out.println("a:"+a);
		num = num3;
		System.out.println("num:"+num);
	}
}	
	
public class MyTest {

	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 2;
		
		Cat cat1 = new Cat();
		cat1.num = 1;
		cat1.a = 10;
		cat1.Print(20);
		System.out.println(cat1.num);
		System.out.println(cat1.a);
		
		Cat cat2 = new Cat();
		cat2.num = 2;
		cat2.a = 11;
		cat2.Print(20);
		System.out.println(cat2.num);
		System.out.println(cat2.a);
		System.out.println(cat1.a); 
		/*이게 왜 11 인지가 중요.
		
		코드상에서 static으로 된걸 실행시킨 자바에서 싹 찾음.
		메모리에 있던 설계도를 데이터로 옮겨서 객체를 만들려고하는것.
		스태틱은 어디에 있던지 꺼내놓기때문에 두번세번생기지않음.
		각클래스마다 있는건 이걸쓰라고 주인만 정해주는것.
		코드에 올라갈떄는 static = 5 값은 이미 없어지고 new만들고 변형.
		데이터=메서드 영역.
		*/
		
		Cat cat3 = new Cat();
		cat3.num = 3;
		cat3.a = 15;
		System.out.println(cat3.num);
		System.out.println(cat1.a);
		System.out.println(cat3.a);
		System.out.println(cat2.a);
		
	}

}
