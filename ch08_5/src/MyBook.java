class Book
{
	int price;
	int num = 0;
	String title;
	
	Book()
	{
		title = "자바 프로그래밍";
		price = 5000;
	}
	Book(String t, int p)
	{
		title = t;
		price = p;
	}
	
	void print()
	{
		System.out.println("제    목 : " + title);
		System.out.println("가    격 : " + price);
		System.out.println("주문수량 : " + num);
		System.out.println("합계금액 : " + price * num);
	}
}

class MyBook {

	public static void main(String[] args) 
	{
		Book book1 = new Book(); //디폴트 생성자를 부르는애 (안만들어도 자동으로생김)
		book1.print();
		
		Book book2 = new Book("자바 디자인패턴", 10000);
		book2.num = 10;
		book2.print();
	}
}

// 생성자는 클래스 이름과 같은 매서드명을 가진다.
// 리턴형이 없다.
//
// 디폴트 생성자(파라미터 없는 애)는 자동으로 생성된다.
//
// 파라미터가 있는 생성자를 만들면
// 디폴트 생성자가 자동으로 생성되지 않는다.
