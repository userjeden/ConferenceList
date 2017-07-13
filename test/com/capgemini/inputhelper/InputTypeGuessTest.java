package com.capgemini.inputhelper;

import static org.junit.Assert.*;
import org.junit.Test;

public class InputTypeGuessTest {

	@Test
	public void shouldGuessNUMBER(){
		
		//GIVEN
		String[] input = {"1", "5", "10", "37", "125", "249", "300", "987"};
		
		//WHEN
		InputTypeEnum[] output = new InputTypeEnum[8];
		InputTypeEnum[] expected = new InputTypeEnum[8];
		for(int i = 0; i < 8; i++){
			output[i] = InputTypeGuess.guess(input[i]);
			expected[i] = InputTypeEnum.NUMBER_INPUT;
		}
		
		//THEN
		assertArrayEquals(expected, output);
	}
	
	
	@Test
	public void shouldNOTGuessNUMBER(){
		
		//GIVEN
		String[] input = {"0", "00", "02", "1d", "f3", "<1", "5>", "abc"};
		
		//WHEN
		InputTypeEnum[] output = new InputTypeEnum[8];
		InputTypeEnum[] expected = new InputTypeEnum[8];
		for(int i = 0; i < 8; i++){
			output[i] = InputTypeGuess.guess(input[i]);
			expected[i] = InputTypeEnum.WRONG_INPUT;
		}
		
		//THEN
		assertArrayEquals(expected, output);
	}
	
	
	@Test
	public void shouldGuessLETTER(){
		
		//GIVEN
		String[] input = {"a", "A", "g", "G", "f", "j", "K", "Z"};
		
		//WHEN
		InputTypeEnum[] output = new InputTypeEnum[8];
		InputTypeEnum[] expected = new InputTypeEnum[8];
		for(int i = 0; i < 8; i++){
			output[i] = InputTypeGuess.guess(input[i]);
			expected[i] = InputTypeEnum.LETTER_INPUT;
		}
		
		//THEN
		assertArrayEquals(expected, output);
	}
	
	
	@Test
	public void shouldNOTGuessLETTER(){
		
		//GIVEN
		String[] input = {"aa", "Aa", "gS", "GG", "f1", "2j", "-K", "AXZ"};
		
		//WHEN
		InputTypeEnum[] output = new InputTypeEnum[8];
		InputTypeEnum[] expected = new InputTypeEnum[8];
		for(int i = 0; i < 8; i++){
			output[i] = InputTypeGuess.guess(input[i]);
			expected[i] = InputTypeEnum.WRONG_INPUT;
		}
		
		//THEN
		assertArrayEquals(expected, output);
	}
	
	
	@Test
	public void shouldGuessWRONG(){
		
		//GIVEN
		String[] input = {"", " ", "\n", "\r", "<", "+", "-", "?"};
		
		//WHEN
		InputTypeEnum[] output = new InputTypeEnum[8];
		InputTypeEnum[] expected = new InputTypeEnum[8];
		for(int i = 0; i < 8; i++){
			output[i] = InputTypeGuess.guess(input[i]);
			expected[i] = InputTypeEnum.WRONG_INPUT;
		}
		
		//THEN
		assertArrayEquals(expected, output);
	}
	
}


