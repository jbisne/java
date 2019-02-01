package step2;

import java.time.LocalDate;

public class Person {
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String addressOne;
	private String addressTwo;
	private String sex;
	private boolean driverLicence;
	private boolean married;
	
	public static PersonBuilder builder() {
		return new PersonBuilder();
	}
	
	public static class PersonBuilder {
		private String firstName;
		private String lastName;
		private LocalDate birthDate;
		private String addressOne;
		private String addressTwo;
		private String sex;
		private boolean driverLicence;
		private boolean married;
		public PersonBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public PersonBuilder lastName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public PersonBuilder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}
		public PersonBuilder addressOne(String addressOne) {
			this.addressOne = addressOne;
			return this;
		}
		public PersonBuilder addressTwo(String addressTwo) {
			this.addressTwo = addressTwo;
			return this;
		}
		public PersonBuilder sex(String sex) {
			this.sex = sex;
			return this;
		}
		public PersonBuilder driverLicence(boolean driverLicence) {
			this.driverLicence = driverLicence;
			return this;
		}
		public PersonBuilder married(boolean married) {
				this.married = married;
				return this;
		}
		public Person build() {
			Person person = new Person();
			person.firstName = this.firstName;
			person.lastName = this.lastName;
			person.addressOne = this.addressOne;
			person.addressTwo = this.addressTwo;
			person.birthDate = this.birthDate;
			person.sex = this.sex;
			person.driverLicence = this.driverLicence;
			person.married = this.married;
			return person;
			
		}
	
	
	}
}
