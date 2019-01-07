class Book
{
	int price;
	String title;
	
	Book(String t, int p)
	{
		title = t;
		price = p;
	}
	
	// 복제 생성자
	Book(Book copy)
	{
		title = copy.title;
		price = copy.price;
	}
	
	void print()
	//오버로딩 해줌.메서드 명은같지만 동작이다른것.
	//이름지을 수고를 줄여줌. 이것때문에 오버로딩쓰는것.
	{
		System.out.println("제    목 : " + title);
		System.out.println("가    격 : " + price);
	}
}

class MyBook 
{

	public static void main(String[] args) //public 이어야 java가 찾는다.
	{
		
		Book book1 = new Book("자바 프로그래밍", 10000);
		book1.print();
			
		Book book2 = new Book(book1);
		book2.title = "자바 디자인패턴";
		book2.print();
	}
}