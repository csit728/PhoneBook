import java.util.Comparator;

public class Person implements Comparator<Person>{

	private String firstName, lastName, phoneNumber;
	private Address address;
	
	

	public Person() {
		super();
	}

	public Person(String firstName, String lastName, Address address, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		//input.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
		return firstName + ", " + lastName + ", " + address + ", " + phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3") ;
	}

	@Override
	public int compare(Person person1, Person person2) {
		return person1.getLastName().compareToIgnoreCase(person2.getLastName());
	}

}
