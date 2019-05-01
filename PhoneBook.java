import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PhoneBook {

	private Person[] entries;

	public PhoneBook() {
		super();
		this.entries = new Person[0];
	}

	public Person[] getEntries() {
		return entries;
	}

	public void setEntries(Person[] entries) {
		this.entries = entries;
	}

	public Person[] expandArray(Person[] sourceArray) {
		Person[] newArray = new Person[sourceArray.length + 1];

		for (int i = 0; i < sourceArray.length; i++) {
			newArray[i] = sourceArray[i];
		}

		return newArray;

	}

	public Person[] decreaseArray(Person[] sourceArray) {
		Person[] newArray = new Person[sourceArray.length - 1];
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = sourceArray[i];
		}

		return newArray;

	}

	public void addEntry(Person newPerson) {
		Person[] expandedArray = expandArray(entries);
		expandedArray[expandedArray.length - 1] = newPerson;
		setEntries(expandedArray);
	}

	public Person[] findByFirstName(String firstName) {
		Person[] results = new Person[0];
		for (int i = 0; i < entries.length; i++) {
			if (entries[i].getFirstName().equals(firstName)) {
				results = expandArray(results);
				results[results.length - 1] = entries[i];
			}

		}
		return results;
	}

	public Person[] findByLastName(String lastName) {
		Person[] results = new Person[0];
		for (int i = 0; i < entries.length; i++) {
			if (entries[i].getLastName().equals(lastName)) {
				results = expandArray(results);
				results[results.length - 1] = entries[i];

			}
		}

		return results;
	}

	public Person[] findByCityOrState(String input) {
		Person[] results = new Person[0];
		for (int i = 0; i < entries.length; i++) {
			if (entries[i].getAddress().getCity().equals(input) || entries[i].getAddress().getState().equals(input)) {
				results = expandArray(results);
				results[results.length - 1] = entries[i];

			}
		}
		return results;
	}

	private int findIndexByPhoneNumber(String phoneNumber) {
		for (int i = 0; i < entries.length; i++) {
			if (entries[i].getPhoneNumber().equals(phoneNumber)) {
				return i;
			}
		}
		return -1;
	}

	public void deleteByPhoneNumber(String phoneNumber) {
		int indexOfRecordToDelete = findIndexByPhoneNumber(phoneNumber);
		if (indexOfRecordToDelete == -1) {
			System.out.println("Record Not Found");
		}

		else {
			for (int i = indexOfRecordToDelete; i < entries.length - 1; i++) {
				entries[i] = entries[i + 1];
			}

			Person[] newArray = decreaseArray(entries);
			setEntries(newArray);
		}

	}

	private Person findByPhoneNumber(String phoneNumber) {
		for (int i = 0; i < entries.length; i++) {
			if (entries[i].getPhoneNumber().equals(phoneNumber)) {
				return entries[i];
			}
		}
		return null;
	}

	public void updateFirstName(String firstName, String phoneNumber) {
		int index = findIndexByPhoneNumber(phoneNumber);
		Person p1 = findByPhoneNumber(phoneNumber);
		p1.setFirstName(firstName);
		entries[index] = p1;
	}

	public List<Person> sort() {
		List<Person> arrayList = new ArrayList<Person>(Arrays.asList(entries));
		List<Person> sortedList = new ArrayList<Person>();
		
		Collections.sort(arrayList, new Person());
		for(int i=0; i<entries.length; i++) {
			sortedList.add(arrayList.get(i));
		}
		
		return sortedList;

	}

}
