abstract class Calc //부모 클래스
{
	int a = 5;
	int b = 6;
	
	abstract void Plus();
}

class MyCalc extends Calc //MyCalc가 Calc 에게 상속받는다.
{
	void Plus()  {System.out.println(a + b); }
	void Minus() {System.out.println(a - b); }
}

class Polymorphism1
{
	public static void main(String[] args) 
	{
		MyCalc myCalc1 = new MyCalc();
		myCalc1.Plus();
		myCalc1.Minus();
		
		//하위클래스 객체를 상위 클래스 객체에 대입
		Calc myCalc2 = new MyCalc();
		myCalc2.Plus();
		// 다음 메서드는 설계도에 없다. 사용 불가능
		// myCalc2.Minus();
	}

	
	}
}
