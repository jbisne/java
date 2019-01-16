class Box7 <L, R> {
	private L left;
	private R right;
	
	public void set (L o, R r) {
		left = o;
		right = r;
	}
	
	@Override
	public String toString() {
		return left + " & " + right;
	}
}

class B1_MultiTypeParam {
	public static void main(String[] args) {
		Box7<String, Integer> box = new Box7<String, Integer>();
		box.set("YEEEE, Apple", 25);
		System.out.println(box);

	}

}
