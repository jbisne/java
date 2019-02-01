package step2;

import java.time.LocalDate;
import java.time.Month;

public class Main {

	public static void main(String[] args) {
	
	}
	
	private Person createPersonForTesting() {
		return Person.builder()
				.firstName("FirstName")
				.lastName("LastName")
				.addressOne("AdddressOne")
				.addressTwo("AddressTwo")
				.birthDate(LocalDate.of(1995, Month.APRIL, 13))
				.sex("male")
				.driverLicence(true)
				.married(true)
				.build();

	}

}
