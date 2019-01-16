class Apple3 {
	public String toString() {
		return "YEE, I am an apple.";
	}
}

class Orange3 {
	public String toString() {
		return "YEEEE, I am an orange.";
	}
}

class Box3 {
	private Object ob;
	
	public void set(Object o) {
		ob = o;
	}
	
	public Object get() {
		return ob;
	}
}

class A3_FruitAndBoxFault {
	public static void main(String[] args) {
		Box3 aBox = new Box3();
		Box3 oBox = new Box3();
		
		//과일을 박스에 담을 것일까
		aBox.set("Apple"); // <--aBox.set(new String("Apple");
		oBox.set("Orange");
		
		//박스에서 과일을 제대로 꺼낼 수 있을까?
		Apple3 ap = (Apple3)aBox.get();
		Orange3 og = (Orange3)oBox.get();
		
		System.out.println(ap);
		System.out.println(og);
	}

}
