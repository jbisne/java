public class B1_BoxingUnboxing {
	public static void main(String[] args) {
		// 인스턴스에 값을 감싸는 박싱
		Integer i0bj = new Integer (10);
		Double d0bj = new Double(3.14);
		
		System.out.println(i0bj);
		System.out.println(d0bj);
		System.out.println();
		
		// 메소드 호출을 통한 언박싱
		int num1 = i0bj.intValue();
		double num2 = d0bj.doubleValue();
		
		System.out.println(num1 + " : " + i0bj);
		System.out.println(num2 + " : " + d0bj);
		System.out.println();
		
		// 래퍼 인스턴스 값의 증가 방법
		i0bj = new Integer(i0bj.intValue() + 10);
		d0bj = new Double (d0bj.doubleValue() + 1.2);
		
		System.out.println(i0bj);
		System.out.println(d0bj);
	}

}
