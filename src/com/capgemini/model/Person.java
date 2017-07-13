package com.capgemini.model;

public class Person implements Comparable<Person> {

	private String firstName;
	private String familyName;
	private String dateOfBirth;
	private String ageYears;

	public String getFirstName() {
		return firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getAgeYears() {
		return ageYears;
	}

	public void setAgeYears(String ageYears) {
		this.ageYears = ageYears;
	}

	public Person(String firstName, String familyName, String dateOfBirth) {
		this.firstName = firstName;
		this.familyName = familyName;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "name: " + firstName + " | surname: " + familyName + " | born: " + dateOfBirth;
	}

	@Override
	public int compareTo(Person o) {

		int familyNameCompare = familyName.compareTo(o.getFamilyName());
		int firstNameCompare = firstName.compareTo(o.getFirstName());

		if (familyNameCompare != 0) {
			return familyNameCompare;

		} else if (firstNameCompare != 0) {
			return firstNameCompare;

		} else {
			return 0;

		}
	}

}
