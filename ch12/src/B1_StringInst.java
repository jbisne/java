class B1_StringInst {
	public static void showString(String str) {
		System.out.println(str);
		System.out.println(str.length());

	}

	public static void main(String[] args) {
		// 둘 다 String 인스턴스의 생성으로 이어지고
		// 그 결과 인스턴스의 참조 값이 반환된다.
		
		String str1 = new String("Simple String");
		String str2 = "The Best String";
		String str3 = "The Best String"; //Debug 모드로 id 살펴보기
		//new 사용해야 수가 바뀌는것. str1에서 new 사용해서 다음
		//str2까지만 바뀌고 그 이후는 그대로인것.
		
		System.out.println(str1);
		System.out.println(str1.length());
		
		System.out.println(); //개행 : 메서드 오버로딩
		
		System.out.println(str2);
		System.out.println(str2.length());
		
		System.out.println();
		
		//showString("Funny String");
		showString(str3);
	
	}
}
