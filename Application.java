
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		PhoneBook phoneBook = new PhoneBook();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Please enter a number to select an option: ");
			System.out.println(
					"1: Add new entries\n2: Search by first name\n3: Search by last name\n4: Search by city and state\n5: Delete a record for given phone number\n6: Update first name\n7: Show records in ascending order\n8: Exit");
			int selection = sc.nextInt();
			sc.nextLine();

			switch (selection) {
			case 1:
				// Add Entry
				System.out.println("Enter your name, address, and phone number seperated by commas");
				String input = sc.nextLine();
				String[] personalInfo = input.split(", ");
				Person person = new Person(personalInfo[0], personalInfo[1],
						new Address(personalInfo[2], personalInfo[3], personalInfo[4], personalInfo[5]),
						personalInfo[6]);
				phoneBook.addEntry(person);
				break;
			case 2:
				// search by first name
				System.out.println("Enter First Name: ");
				String firstName = sc.nextLine();
				Person[] result = phoneBook.findByFirstName(firstName);
				if (result.length == 0) {
					System.out.println("Record Not Found");
				} else {
					for (int i = 0; i < result.length; i++) {
						System.out.println(result[i].toString());
					}
				}
				break;
			case 3:
				// search by last name
				System.out.println("Enter a last name: ");
				String lastName = sc.nextLine();
				Person[] results = phoneBook.findByLastName(lastName);
				if (results.length == 0) {
					System.out.println("Record Not Found");
				} else {
					for (int i = 0; i < results.length; i++) {
						System.out.println(results[i].toString());
					}
				}
				break;
			case 4:
				// search by city and state
				System.out.println("Enter a city or state:");
				String search = sc.nextLine();

				Person[] searchResult = phoneBook.findByCityOrState(search);
				if (searchResult.length == 0) {
					System.out.println("Record Not Found");
				}

				else {
					for (int i = 0; i < searchResult.length; i++) {
						System.out.println(searchResult[i].toString());
					}
				}
				break;
			case 5:
				// delete record for a given phone number
				System.out.println("Enter phone number for record you want to delete:");
				String phoneNum = sc.nextLine();
				phoneBook.deleteByPhoneNumber(phoneNum);
				break;
			case 6:
				// update first name for a given phone number
				System.out.println("Enter phone number:");
				String numEntered = sc.nextLine();
				System.out.println("Enter First Name:");
				String nameEntered = sc.nextLine();

				phoneBook.updateFirstName(nameEntered, numEntered);
				break;
			case 7:
				System.out.println(phoneBook.sort());
				break;
			case 8:
				// exit program
				System.out.println("Exiting...");
				System.exit(0);
			}

		}

	}
}
