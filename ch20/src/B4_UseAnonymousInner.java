interface Printable3 {
	void print();
}

class Papers3 {
	private String con;
	public Papers3(String s) { con = s;	}
	
	public Printable3 getPrinter() {
		return new Printable3() {
			public void print () { System.out.println(con); }
		};
	// new 없다고 뭐라하기 NO. 
	// 그래서 여기 구현되게 식 적어논것.
		
	}
}
class B4_UseAnonymousInner {
	public static void main(String[] args) {
		Papers3 p = new Papers3("서류 내용 : 행복합니다.");
		Printable3 prn = p.getPrinter();
		prn.print();
	}
}
