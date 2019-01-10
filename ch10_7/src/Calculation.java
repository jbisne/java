abstract  class Calc
{
	int a;
	int b;
	
	abstract int result();
	
	void printResult()
	{
		System.out.println((result()));
	}

	void setData(int m, int n)
	{
		a = m;
		b = n;
	}
}

class Plus extends Calc
{
	int result( ) { return a + b; }
	
}
class Minus extends Calc
{
	int result() { return a - b; }
}
class Calculation 
{
	public static void main(String[] args)
	{
		int x=54, y=12;
		Calc calc1 = new Plus();
		Calc calc2 = new Minus();
		
		calc1.setData(x, y);
		calc2.setData(x, y)	;
		
		System.out.println(x + "+" + y + "=");
		calc1.printResult();
		
		System.out.println(x + "-" + y + "=");
		calc2.printResult();
		
		
	}
}
