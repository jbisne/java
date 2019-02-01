package pattern01.singleton.step3;

public class Main {

	public static void main(String[] args) {
		Database database;
		
		database =Database.getInstance("첫 번째 Database");
		System.out.println("Thsis is the " + database.getConnection() + " !!!");
		
		database =Database.getInstance("두 번째 Database");
		System.out.println("Thsis is the " + database.getConnection() + " !!!");
		

	}

}
