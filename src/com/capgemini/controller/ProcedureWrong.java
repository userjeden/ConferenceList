package com.capgemini.controller;

public class ProcedureWrong implements Procedure {

	public ProcedureWrong(String userInput) {
		System.out.println(userInput + " is not a correct input");
	}
	
	@Override
	public void runProcedure() {
		System.out.println("please provide correct input");
	}

}
