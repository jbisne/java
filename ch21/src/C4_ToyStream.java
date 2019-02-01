import java.util.ArrayList;
import java.util.List;

class ToyPriceInfo {
	private String model;
	private int price;
	
	public ToyPriceInfo(String m, int p) {
		model = m;
		price = p;
	}
	
	public int getPrice() {
		return price;
	}
}

public class C4_ToyStream {
	public static void main(String[] args) {
		List<ToyPriceInfo> ls = new ArrayList<>();
		ls.add(new ToyPriceInfo("TEEEY _BEAR_S_014", 350));
		ls.add(new ToyPriceInfo("CAR_TRANSFORM_VER_7719", 550));
		
		int sum = ls.stream()
						.filter(p -> p.getPrice() < 500)
						.mapToInt(t -> t.getPrice())
						.sum();
		
		System.out.println("sum = " + sum);
		

	}

}
