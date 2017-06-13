package de.uni_koeln.info.java.model;

import java.io.Serializable;

public class PhoneBookEntry implements Comparable<PhoneBookEntry>, Serializable {

	private static final long serialVersionUID = -1164977423080924105L;

	private String firstName, lastName;
	private String phoneNumber;
	private Address adress;
	private String email;

	public PhoneBookEntry(String lastName, String firstName, String phoneNumber, Address adress, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.adress = adress;
		this.email = email;
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

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(PhoneBookEntry o) {
		return this.getLastName().compareTo(o.getLastName());
	}

	
}
