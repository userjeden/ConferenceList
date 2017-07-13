package com.capgemini.model;

import java.util.Comparator;

public class PersonComparator {
	
	public static class ByFirstName implements Comparator<Person>{

		@Override
		public int compare(Person p1, Person p2) {
			return p1.getFirstName().compareTo(p2.getFirstName());
		}
	}
	
	public static class ByFamilyName implements Comparator<Person>{

		@Override
		public int compare(Person p1, Person p2) {
			return p1.getFamilyName().compareTo(p2.getFamilyName());
		}
	}

}
