package com.addressbook;

import org.junit.Test;

public class AddressBookTest {

	@Test
	public void test() {
		Contact[] contactdata = { 
				new Contact("Dinesh", "Thiyagarajan", "Virudhunagar", "Tamilnadu", "8608894623", "626619", "dinesh@gmail.com"),
				new Contact("Karthik", "Chandrasekar", "Virudhunagar", "Tamilnadu", "8956231456", "626618", "karthik@gmail.com")};
		AddressBook addressBook = new AddressBook(contactdata);
		
		addressBook.writedata();
		addressBook.readdata();
		
	}

}
