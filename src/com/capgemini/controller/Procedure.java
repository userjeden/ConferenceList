package com.capgemini.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.model.Person;

public interface Procedure {

	public void runProcedure();

	default void updatePersonAge(List<Person> personList) {
		LocalDate currentDate = LocalDate.now();
		for (Person p : personList) {
			String dateOfBirth = p.getDateOfBirth();
			LocalDate pastDate = LocalDate.parse(dateOfBirth);
			Period period = Period.between(pastDate, currentDate);
			String ageYears = String.valueOf(period.getYears());
			p.setAgeYears(ageYears);
		}
	}

	default List<Person> loadCSV() {
		List<Person> personList = new LinkedList<Person>();
		BufferedReader buffRead;

		try {
			buffRead = new BufferedReader(new FileReader("res/konferencja.CSV"));
			String line;
			while ((line = buffRead.readLine()) != null && !line.isEmpty()) {
				String[] fields = line.split(",");
				String firstName = fields[0];
				String familyName = fields[1];
				String dateOfBirth = fields[2];

				Person person = new Person(firstName, familyName, dateOfBirth);
				personList.add(person);
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("file error: missing comma");
			return personList = new LinkedList<Person>();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return personList;
	}

}
