package com.oocl;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GuessNumberTest {

	@Test
	public void should_return_random_answer() {
		GuessNumber guessNumber = new GuessNumber();

		String randomAnswer = guessNumber.generateRandomAnswer();
		System.out.println(randomAnswer);
	}

	@Test
	public void should_return_invalid_and_invalid_input_message() {
		GuessNumber guessNumber = new GuessNumber();

		String randomAnswer = guessNumber.generateRandomAnswer();
		System.out.println(randomAnswer);

		assertEquals("Wrong Input，Input again", guessNumber.validateInput("1134"));
		assertEquals("Wrong Input，Input again", guessNumber.validateInput("12"));
		assertEquals("ok", guessNumber.validateInput("1234"));
	}
}
