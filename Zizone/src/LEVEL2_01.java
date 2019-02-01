class Student2 {
	private int studentNumber;	//멤버 변수
	private String studentName;
	
	Student2(int studentNumber, String studentName) {	//생성자
		this.studentNumber = studentNumber;		
		this.studentName = studentName;
	}
	
	public int getStudentNumber() { return studentNumber; }
	
	public String getStudentName() { return studentName; }
}

public class LEVEL2_01 {
	public static void main(String[] args) {
		int[] stuNum = {1,2,3,4,5,6,7,8,9,10};
		String[] stuName = {"Allen", "Bella","Cathy","Daisy","Emilly",
							"Fage", "Grace","Hannah","Inith","Jeniffer"};
		
		Student2[] stuArray = new Student2[10];
		stuArray = c(stuArray, stuNum, stuName);
		printArray(stuArray);
	}
	
	static Student2[] c(Student2[] stuArray, int[] stuNum, String[] stuName) {
		for (int i = 0; i < 10; i++) {
			stuArray[i] = new Student2(stuNum[i], stuName[i]);
			//클래스 배열 	//클래스 객체생성
		}
		return stuArray;
	}
	
	static void printArray(Student2[] stuArray) {
		for(int i=0; i < 10; i++) {
			System.out.println("학생 번호 : " +stuArray[i].getStudentNumber());
			System.out.println("학생 이름 : " +stuArray[i].getStudentName());
		}

	}

}
