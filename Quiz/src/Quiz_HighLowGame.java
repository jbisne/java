import java.util.Random;
import java.util.Scanner;

public class Quiz_HighLowGame {

	public static void main(String[] args) 
	{
		Random rand = new Random();
		int com = rand.nextInt(101); 
		
		System.out.println("나는 지금 0부터 100사이의 값 중에 하나를 생각하겠습니다.");
		System.out.println("당신은 그 숫자를 6회안에 맞추시면 됩니다.");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇이라고 생각합니까? <0 to 100> ");
		
		int num1 = sc.nextInt();
		
		while(true) 
			
			for(int i=5; i>=0 ; i--) {
			
			if (num1 == com) {
				System.out.printf("%d" + " 는 정답입니다. 축하합니다!\n, num1");
			}	
			else if (num1 < com) {
				System.out.printf("%d" + " 는 제가 정한 숫자보다 작습니다.\n", num1);
				System.out.printf("["+i+"]"+" 의 기회가 남았습니다.");
			}	
			else if (num1 > com) {
				System.out.printf("%d" + " 는 제가 정한 숫자보다 큽니다.\n", num1);
				System.out.printf("["+i+"]"+" 의 기회가 남았습니다.");
			}	
			
			//요기까지는 완성. 이제 여기서 i반복 조건만 맞춰주기. for문 하위로.
			
			System.out.println("게임을 더 진행하시겠습니가? (y/n)");
			String str = sc.next();
			if (!str.equalsIgnoreCase("y")) {
				System.out.println("Good bye~");
				break;
			}
		}

	}

}
