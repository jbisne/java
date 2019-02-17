public class Test1 
{
	public static void main(String[] args) 
	{
		String msg = "/to id abc def";
		int begin = msg.indexOf(" ") + 1;
		int end = msg.indexOf(" ", begin);

		String id = msg.substring(begin, end);
		String message = msg.substring(end+1);

		System.out.println(begin);
		System.out.println(end);
		System.out.println(id);
		System.out.println(message);

			
		}
	}
//begin은4    end는6