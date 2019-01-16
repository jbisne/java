class Apple6 {
	public String toString() {
		return "YEE, I am an apple.";
	}
}

class Orange6 {
	public String toString() {
		return "YEEEE, I am an orange.";
	}
}

class Box6<T> {
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	
	public T get() {
		return ob;
	}
}

class A6_FruitAndBox2_Generic {
	public static void main(String[] args) {
		Box6<Apple6> aBox = new Box6<Apple6>();
		Box6<Orange6> oBox = new Box6<Orange6>();
		
		// 과일을 박스에 담는다.
//		aBox.set("Apple");
//		oBox.set("Orange");
		
		//박스에서 과일을 꺼내는데 형 변환 하지 않는다.
		Apple6 ap = aBox.get();
		Orange6 og = oBox.get();
		
		System.out.println(ap);
		System.out.println(og);
	}

}