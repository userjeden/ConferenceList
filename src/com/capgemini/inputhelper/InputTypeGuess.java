package com.capgemini.inputhelper;

public class InputTypeGuess {
	
	public static InputTypeEnum guess(String input){
		
		if (input.matches("[1-9][0-9]*")){
			return InputTypeEnum.NUMBER_INPUT;
			
		}else if (input.matches("[a-zA-Z]{1}")){
			return InputTypeEnum.LETTER_INPUT;
			
		}else{
			return InputTypeEnum.WRONG_INPUT;
			
		}
	}

}
