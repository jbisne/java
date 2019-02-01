import java.time.ZoneId;

public class B2_ZoneIdDemo2 {

	public static void main(String[] args) {
		ZoneId.getAvailableZoneIds()
			.stream()
//			.filter(s -> s.startsWith("Asia")) //풀면 Asia만 구하는 것
			.sorted()
			.forEach(s -> System.out.println(s));

	}

}
