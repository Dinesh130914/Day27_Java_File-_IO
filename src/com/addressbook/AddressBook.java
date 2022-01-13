package com.addressbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook {

	static List<Contact> addressBook;
	public static String CONTACT_FILE_PATH = "addressbook.txt";

	public AddressBook(Contact[] contactdat) {
		addressBook = Arrays.asList(contactdat);
	}

	public static void main(String[] args) {
		addressBook = new LinkedList<Contact>();
		boolean isExit = false;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Address Book System");

		while (!isExit) {
			System.out.println("Select the option from below");

			if (addressBook.isEmpty()) {

				System.out.println("1. Add Contact\n" + "6.Number Contacts\n7. Exit");
			} else {

				System.out.println("1. Add Contact"
						+ "\n2. Display Contact\n3. Edit Contact\n4.Delete Contact\n5.Search(By City)\n6.Number Of Contacts\n 7.Exit");
			}

			String option = scanner.nextLine();

			switch (option) {
			case "1":
				addContact(scanner);
				break;

			case "2":
				showContacts();
				break;

			case "3":
				editContact(scanner);
				break;

			case "4":
				deleteContact(scanner);
				break;

			case "5":
				searchCity(scanner);
				break;

			case "6":

				if (!addressBook.isEmpty()) {
					numOfContacts(scanner);
				} else {
					System.out.println("No Contacts");
				}
				break;

			case "7":
				isExit = true;
				System.out.println("Sorted By Name");
				sortedAddressbook();
				System.out.println("Sorted by City");
				sortedAddressbookWithCity();
				break;

			default:
				System.out.println("Invalid option choosed.");
				break;
			}
		}
		scanner.close();
	}

	public static String validateFirstName(String firstName, Scanner scanner) {
		String resultPattern = "^[A-Z]{1}[a-z]{2,9}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(firstName);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid first name, please try again");
			firstName = scanner.nextLine();
			inputMatcher = regex.matcher(firstName);
		}
		return firstName;
	}

	public static String validateLastName(String lastName, Scanner scanner) {
		String resultPattern = "^[A-Z]{1}[a-z]{2,9}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(lastName);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid Last name, please try again");
			lastName = scanner.nextLine();
			inputMatcher = regex.matcher(lastName);
		}
		return lastName;
	}

	public static String validateCity(String city, Scanner scanner) {
		String resultPattern = "^[A-Z]{1}[a-z]{2,}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(city);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid city, please try again");
			city = scanner.nextLine();
			inputMatcher = regex.matcher(city);
		}
		return city;
	}

	public static String validateState(String state, Scanner scanner) {
		String resultPattern = "^[A-Z]{1}[a-z]{2,}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(state);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid State, please try again");
			state = scanner.nextLine();
			inputMatcher = regex.matcher(state);
		}
		return state;
	}

	public static String validatePhone(String phone, Scanner scanner) {
		String resultPattern = "^[+]{0,1}[0-9]{0,2}[0-9]{10}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(phone);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid Phone number, please try again");
			phone = scanner.nextLine();
			inputMatcher = regex.matcher(phone);
		}
		return phone;
	}

	public static String validateEmail(String email, Scanner scanner) {
		String resultPattern = "^[a-z.]{2,30}@{1}[a-z]{3,10}.[a-z]{3}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(email);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid Email, please try again");
			email = scanner.nextLine();
			inputMatcher = regex.matcher(email);
		}
		return email;
	}

	public static String validateZipcode(String zip, Scanner scanner) {
		String resultPattern = "^[0-9]{0,6}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(zip);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid Zip code, please try again");
			zip = scanner.nextLine();
			inputMatcher = regex.matcher(zip);
		}
		return zip;
	}

	private static void addContact(Scanner scanner) {
		Contact contact = new Contact();

		System.out.println("Enter First Name: ");
		String firstName = scanner.nextLine();
		contact.setFirstname(validateFirstName(firstName, scanner));

		System.out.println("Enter Last Name: ");
		String lname = scanner.nextLine();
		contact.setLastname(validateLastName(lname, scanner));

		System.out.println("Enter city : ");
		String city = scanner.nextLine();
		contact.setCity(validateCity(city, scanner));

		System.out.println("Enter state : ");
		String state = scanner.nextLine();
		contact.setState(validateState(state, scanner));

		System.out.println("Enter Zip code : ");
		String zip = scanner.nextLine();
		contact.setZipcode(validateZipcode(zip, scanner));

		System.out.println("Enter Email Id: ");
		String email = scanner.nextLine();
		contact.setEmail(validateEmail(email, scanner));

		System.out.println("Enter phone  number: ");
		String phone = scanner.nextLine();
		contact.setPhonenumber(validatePhone(phone, scanner));

		addressBook.add(contact);
		System.out.println("Contact has been saved.");
	}

	private static void editContact(Scanner scanner) {
		System.out.println("Which contact you want to Edit? (Enter the First name)");
		String firstName = scanner.nextLine();

		Contact editContact = null;
		for (int i = 0; i < addressBook.size(); i++) {
			if (firstName.equals(addressBook.get(i).getFirstname())) {
				editContact = addressBook.get(i);
			}
		}

		if (editContact == null) {
			System.out.println("No contact found with name " + firstName + ".");
		} else {
			editContactDetails(editContact, scanner);
		}
	}

	private static void editContactDetails(Contact editContact, Scanner scanner) {
		System.out.println("Enter First Name: ");
		String firstName = scanner.nextLine();
		editContact.setFirstname(validateFirstName(firstName, scanner));

		System.out.println("Enter Last Name: ");
		String lname = scanner.nextLine();
		editContact.setLastname(validateLastName(lname, scanner));

		System.out.println("Enter City : ");
		String city = scanner.nextLine();
		editContact.setCity(validateCity(city, scanner));

		System.out.println("Enter state : ");
		String state = scanner.nextLine();
		editContact.setState(validateState(state, scanner));

		System.out.println("Enter Zip Code: ");
		String zip = scanner.nextLine();
		editContact.setZipcode(validateZipcode(zip, scanner));

		System.out.println("Enter Your Email: ");
		String email = scanner.nextLine();
		editContact.setEmail(validateEmail(email, scanner));

		System.out.println("Enter Phone Number: ");
		String phoneNumber = scanner.nextLine();
		editContact.setPhonenumber(validatePhone(phoneNumber, scanner));

		System.out.println("Contact has been edited.");
	}

	private static void showContacts() {
		if (addressBook.isEmpty()) {
			System.out.println("Address book is empty.");
		} else {
			for (Contact contact : addressBook) {
				System.out.println(contact);
			}
		}
	}

	private static void deleteContact(Scanner scanner) {
		System.out.println("Which contact you want to Delete? (Enter the First name)");
		String firstName = scanner.nextLine();

		Contact deleteContact = null;
		for (int i = 0; i < addressBook.size(); i++) {
			if (firstName.equals(addressBook.get(i).getFirstname())) {
				deleteContact = addressBook.remove(i);
			}
		}

		if (deleteContact == null) {
			System.out.println("No contact found with name " + firstName + ".");
		} else {
			System.out.println(deleteContact.getFirstname() + "'s contact has been removed from your Address Book.");
		}
	}

	private static void searchCity(Scanner scanner) {
		System.out.println("Search the name by using City");
		String city = scanner.nextLine();

		addressBook.stream().filter(contacts -> contacts.getCity().equalsIgnoreCase(city)).forEach(System.out::println);
		;
	}

	private static void numOfContacts(Scanner scanner) {

		System.out.println("Number of contacts by using state");
		String state = scanner.next();

		long count = addressBook.stream().filter(contacts -> contacts.getState().equalsIgnoreCase(state)).count();
		System.out.println("Number Of Contacts :" + count);
	}

	private static void sortedAddressbook() {
		Comparator<Contact> nameComparator = Comparator.comparing(Contact::getFirstname);
		addressBook.stream().sorted(nameComparator).forEach(System.out::println);
		;
	}

	private static void sortedAddressbookWithCity() {
		Comparator<Contact> nameComparator = Comparator.comparing(Contact::getCity);
		addressBook.stream().sorted(nameComparator).forEach(System.out::println);
		;
	}

	public void writedata() {

		StringBuffer buffer = new StringBuffer();
		addressBook.forEach(cont -> buffer.append(cont + "\n"));
		try {
			System.out.println("Write data to file completed");
			Files.write(Paths.get(CONTACT_FILE_PATH), buffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readdata() {
		try {
			Files.lines(Paths.get(CONTACT_FILE_PATH)).map(line->line.trim()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
