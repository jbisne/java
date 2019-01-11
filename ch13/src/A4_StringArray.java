class A4_StringArray {
	public static void main(String[] args) {
		String[] sr = new String[7];
		
		sr[0] = new String("홍길동");
		sr[1] = new String("전우치");
		sr[2] = new String("손오공");
		sr[3] = new String("강감찬");
		sr[4] = new String("이순신");
		sr[5] = new String("을지문덕");
		sr[6] = new String("양만춘");
		
		//출석부라는 개념
		
		int cnum = 0;
		
		for(int i = 0; i < sr.length; i++)
			cnum += sr[i].length();
		
		System.out.println("총 문자의 수 : " + cnum);
	}

}
//배열 기반 반복문 활용의 예
