public class C_DoubleEx {

	public static void main(String[] args) {
		
		double dnum = 1;
		
		for (int i=0; i<10000; i++) {
			dnum = dnum + 0.1;
		} // for문의 경우 한줄중괄호 생략가능 but 두줄 이상될 경우 중괄호 필수
		System.out.println(dnum);
	}

}
