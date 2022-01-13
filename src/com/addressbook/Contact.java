package com.addressbook;

public class Contact {
	public Contact(String firstname, String lastname, String city, String state, String phonenumber, String zipcode,
			String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
		this.state = state;
		this.phonenumber = phonenumber;
		this.zipcode = zipcode;
		this.email = email;
	}
	
	public Contact()
	{
		
	}

	private String firstname, lastname, city, state, phonenumber, zipcode, email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Contact Details :\n " + "FirstName :" + firstname + " \nLast Name :" + lastname + " \nPhone Number :"
				+ phonenumber + " \nCity :" + city + " \nState : " + state + " \nZip Code  :" + zipcode;
	}
}
