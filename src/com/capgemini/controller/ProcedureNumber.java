package com.capgemini.controller;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.data.DataExport;
import com.capgemini.model.Person;
import com.capgemini.model.PersonComparator;

public class ProcedureNumber implements Procedure{

	private String userInput;
	private List<Person> rawInputPersonList;
	private List<LinkedList<Person>> targetListPersonList;

	public ProcedureNumber(String userInput) {
		System.out.println("invoked number procedure");
		this.userInput = "" + userInput;
	}

	@Override
	public void runProcedure() {
		loadDataFromCSVFile();
		sortRawColletion();
		updateAgeInformation();
		prepTargetCollection();
		saveOutputFile();
	}

	private void loadDataFromCSVFile() {
		rawInputPersonList = Procedure.super.loadCSV();
	}
	
	private void sortRawColletion() {
		rawInputPersonList.sort(new PersonComparator.ByFamilyName());
	}
	
	private void updateAgeInformation() {
		Procedure.super.updatePersonAge(rawInputPersonList);
	}

	public void prepTargetCollection() {
		int listSize = Integer.parseInt(userInput) - 1;
		targetListPersonList = new LinkedList<LinkedList<Person>>();
		while(rawInputPersonList.size() > 0){
			
			LinkedList<Person> tempList = new LinkedList<Person>();
			for(int i = 0; i <= listSize; i++){
				tempList.add(rawInputPersonList.remove(0));
				if(rawInputPersonList.size() < 1){
					break;
				}
			}
			targetListPersonList.add(tempList);
		}
	}


	private void saveOutputFile() {
		int listNumbering = 1;
		for(LinkedList<Person> list : targetListPersonList){
			DataExport dataExport = new DataExport();
			dataExport.savePersonsToFile(list, String.valueOf(listNumbering));
			listNumbering++;
		}
	}

}
