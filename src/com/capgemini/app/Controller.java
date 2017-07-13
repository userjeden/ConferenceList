package com.capgemini.app;

import java.util.Scanner;

import com.capgemini.controller.Procedure;
import com.capgemini.controller.ProcedureLetter;
import com.capgemini.controller.ProcedureNumber;
import com.capgemini.controller.ProcedureWrong;
import com.capgemini.inputhelper.InputTypeEnum;
import com.capgemini.inputhelper.InputTypeGuess;

public class Controller {

	/**
	 * input file: konfernecja.csv included in resources
	 * output file: please provide output folder C:/projects
	 * 
	 * dividing people by family name: any letter will be accepted
	 * dividing people into groups: any number will be accepted
	 * 
	 * IDEA FOR FUTURE: 
	 * 
	 * use observer pattern - any procedure registers in controller as an observer
	 * which allows adding additional logic without changes to this class
	 */
	public void run(){
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Procedure procedure;
		while (sc.hasNextLine()) {

			String inputContent = sc.nextLine().toLowerCase();
			InputTypeEnum inputType = InputTypeGuess.guess(inputContent);

			switch (inputType) {

			case LETTER_INPUT:
				System.out.println("recognized letter input");
				procedure = new ProcedureLetter(inputContent);
				procedure.runProcedure();
				break;

			case NUMBER_INPUT:
				System.out.println("recognized number input");
				procedure = new ProcedureNumber(inputContent);
				procedure.runProcedure();
				break;

			case WRONG_INPUT:
				System.out.println("recognized wrong input");
				procedure = new ProcedureWrong(inputContent);
				procedure.runProcedure();
				break;

			}
		}
	}
	
}
