class Box {
	private String contents;
	private int boxNum;
	
	Box(int num, String cont) {
		boxNum = num;
		contents = cont;
	}

	public int getBoxNum() {
		return boxNum;
	}	
		public String toString()	{
			return contents;
	}
}
public class D2_EnhancedForInst {
	public static void main(String[] args) {
		Box[] ar = new Box[5];
		
		ar[0] = new Box(101, "Coffee");
		ar[1] = new Box(101, "Computer");
		ar[2] = new Box(101, "Apple");
		ar[3] = new Box(101, "Dress");
		ar[4] = new Box(101, "Fairy-tale book");
		
		for(Box e :ar) {
			if(e.getBoxNum() == 505 )
				System.out.println(e);
		}

	}

}
