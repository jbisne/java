class Student {
	private int studentNumber;	//멤버 변수
	private String studentName;
	
	Student(int studentNumber, String studentName) {	//생성자
		this.studentNumber = studentNumber;		
		this.studentName = studentName;
	}
	
	public int getStudentNumber() { return studentNumber; }
	
	public String getStudentName() { return studentName; }
}

public class LEVEL1_02 {
	public static void main(String[] args) {
		int[] stuNum = {1,2,3,4,5,6,7,8,9,10};
		String[] stuName = {"Allen", "Bella","Cathy","Daisy","Emilly",
							"Fage", "Grace","Hannah","Inith","Jeniffer"};
		
		Student[] stuArray = new Student[10];
		for (int i = 0; i < 10; i++) {
			stuArray[i] = new Student(stuNum[i], stuName[i]);
			
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println("학생 번호 : " + stuArray[i].getStudentNumber());
			System.out.println("학생 이름 : " + stuArray[i].getStudentName());
		}

	}

}
