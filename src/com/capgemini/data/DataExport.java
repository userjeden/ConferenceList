package com.capgemini.data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.capgemini.model.Person;

public class DataExport {

	String csvFilePath = "";

	public void savePersonsToFile(List<Person> persons, String fileNameSign){
		if(persons.size() > 0){
			prepareFileName(fileNameSign);
			writeFile(prepareData(persons));
			System.out.println("saved: " + csvFilePath);
		}
	}
	
	private void prepareFileName(String fileNameSign) {
		csvFilePath = "C:/projects/persons_" + fileNameSign + ".csv";
	}

	private String prepareData(List<Person> persons){
		
		StringBuilder strb = new StringBuilder();
		for(Person p : persons){
			
			strb.append(p.getFirstName());
			strb.append(", ");
			strb.append(p.getFamilyName());
			strb.append(", ");
			strb.append(p.getAgeYears());
			strb.append("\n");
		}
		
		return strb.toString();
	}
	
	private void writeFile(String content){
		
        try {
			FileWriter writer = new FileWriter(csvFilePath);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(content);
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
}
