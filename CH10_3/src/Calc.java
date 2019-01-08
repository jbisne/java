abstract class Calc 
{
	int a;
	int b;
	abstract void answer();
	
	void setData(int m, int n)
	{
		a=m;
		b=n;
		
	 }
}

class Plus extends Calc
{
	void answer()
	{
		System.out.println(a + "+" + b + "="  +(a+b));
	}
}
class Calculation
{

	 public static void main(String[] args)
	 {
		 Plus plus = new Plus();
		 plus.setData(27,32);
		 plus.answer();;
		
	}

}
