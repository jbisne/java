class Book 
{

	String title;
	String author;
	int money;
}

class 사람
{
	int 키;
	int 나이;
	String 이름;
}

class MyBook	
{
		
	public static void main(String[] args) 
	{
		//'사람'이란 설계도(클래스)를 이용해 사람(객체) 만들기(메모리에 적재)
		사람 man1 = new 사람();
		man1.키 = 175;
		man1.나이 = 25;
		man1.이름 = "홍길동";
		
		System.out.println(man1.키 + " : " +
				   man1.나이 + " : " +
				   man1.이름);

		
		Book book1 = new Book();
		/*int double같은애들은 기본형이라 안써줘도됨.
		  Book 은 새로운 타입이 있기때문에 new를 써줘야함 */
		book1.title = "자바 프로그래밍";
		book1.author = "홍길동";
		book1.money = 15000;
		
		System.out.println(book1.title + " : " +
						   book1.author + " : " +
						   book1.money);
		

	}
}