class B3_CompString {
	public static void main(String[] args) {
		String st1 = "A"; //Apple, Apple
		String st2 = "B"; //apple, Banana
		int cmp;
		
		//인스턴스의 내용 비교
		//equals는 같냐 다르냐만 알려줌
		//얘는 결과가 2개 (같다 다르다)
		if(st1.equals(st2))
			System.out.println("두 문자열은 같습니다.");
		else
			System.out.println("두 문자열은 다릅니다.");
		
		cmp = st1.compareTo(st2);
		//compareTo라는 메서드가 하는게 1 과 2를 비교해주는거다.
		
		if(cmp == 0)
		//얘는 결과(리턴값)이 3개 (같다 크다 작다)
			System.out.println("두 문자열은 일치합니다.");
		else if (cmp < 0)
			System.out.println("사전의 앞에 위치하는 문자: " +st1);
		else
			System.out.println("사전의 앞에 위치하는 문자: " +st2);
		
		if(st1.compareToIgnoreCase(st2) == 0)
			System.out.println("두 문자열은 같습니다.");
		else
			System.out.println("두 문자열은 다릅니다.");

	}

}
