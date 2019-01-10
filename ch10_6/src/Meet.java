interface Greet
{
	void greet();
}

interface Bye extends Greet
{
	void bye();
}

class Greeting implements Bye
{
//Bye도 구현을 해야한다는 뜻이다. 안그러면 에러남!
	public void greet()
	{
		System.out.println("안녕하세요!");
	}

	public void bye()
	{
		System.out.println("안녕히 계세요.");
	}
}

class Meet 
{

	public static void main(String[] args) 
	{
		Greeting greeting = new Greeting();
		greeting.greet();
		greeting.bye();
	}
}
