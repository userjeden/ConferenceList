package com.capgemini.controller;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.data.DataExport;
import com.capgemini.model.Person;
import com.capgemini.model.SorterInsertion;

public class ProcedureLetter implements Procedure {

	private String userInput;
	private List<Person> rawInputPersonList;
	private List<Person> targetPersonList;

	public ProcedureLetter(String userInput) {
		System.out.println("invoked letter procedure");
		this.userInput = "" + userInput;
	}

	@Override
	public void runProcedure() {
		loadDataFromCSVFile();
		prepTargetCollection();
		sortTargetCollection();
		updateAgeInformation();
		saveOutputFile();
	}

	private void loadDataFromCSVFile() {
		rawInputPersonList = Procedure.super.loadCSV();
	}

	public void prepTargetCollection() {
		targetPersonList = new LinkedList<>();
		for (Person p : rawInputPersonList) {
			if (p.getFamilyName().startsWith(userInput.toUpperCase())) {
				targetPersonList.add(p);
			}
		}
	}

	private void sortTargetCollection() {
		SorterInsertion sorter = new SorterInsertion();
		sorter.sortByNames(targetPersonList);
	}

	private void updateAgeInformation() {
		Procedure.super.updatePersonAge(targetPersonList);
	}

	private void saveOutputFile() {
		DataExport dataExport = new DataExport();
		dataExport.savePersonsToFile(targetPersonList, userInput);
	}

}
