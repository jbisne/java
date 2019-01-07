public class G_InfRecul {

	public static void main(String[] args) {
		showHi(3);
	}
	
	public static void showHi(int cnt) {
		System.out.println("Hi~" + cnt);
		
		if(cnt == 1)
			return;
		
//		cnt = cnt - 1;
//		showHi(cnt--);		// 무한 호출. 실행하지 말 것!
//		만약 위처럼 쓸거면 cnt = cnt - 1; 위에입력해줘야함.
		showHi(--cnt);
	}

}
