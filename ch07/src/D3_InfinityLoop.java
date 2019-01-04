public class D3_InfinityLoop {

	public static void main(String[] args) {
		int num = 1;
		
		while(true) {	//true -> 무한반복, break로 빼주는것.
			if(((num % 6) == 0) && ((num % 14) == 0))
				break;
			
			num++;
		}

		System.out.println(num);
	}

}
