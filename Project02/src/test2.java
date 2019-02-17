public class test2 
{
	public static void main(String[] args) 
	{
		String msg = "/to idid abc def ghhjk";
		int begin = msg.indexOf(" ") + 1;
		int end = msg.indexOf(" ", begin);
		//비긴부터 시작해서 첫 공백이 나오면 그 인덱스를 end로
		//index는 0부터 센다
		//indexof는 인덱스를 구하는것 / 자르는건 substring

		String id = msg.substring(begin, end);
		//begin(4)부터 end(8)까지의 글자(String)을 추출
		String message = msg.substring(end+1);
		//end(8)보다 한칸더 자리의 글자부터 추출

		System.out.println(begin);
		System.out.println(end);
		System.out.println(id);
		System.out.println(message);

			
		}
	}
	