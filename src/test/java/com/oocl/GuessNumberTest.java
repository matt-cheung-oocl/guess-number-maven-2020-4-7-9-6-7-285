package com.oocl;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GuessNumberTest {

	@Test
	public void should_return_random_answer() {
		GuessNumber guessNumber = new GuessNumber();
		RandomAnswerGenerator randomAnswerGenerator = new RandomAnswerGenerator();
		String randomAnswer = randomAnswerGenerator.generate();
		System.out.println(randomAnswer);
	}

	@Test
	public void should_return_invalid_and_invalid_input_message() {
		GuessNumber guessNumber = new GuessNumber();

		assertEquals(false, guessNumber.validateInput("1134"));
		assertEquals(false, guessNumber.validateInput("12"));
		assertEquals(true, guessNumber.validateInput("1234"));
	}

	@Test
	public void should_return_correct_output() {
		GuessNumber guessNumber = new GuessNumber();

		assertEquals("4A0B", guessNumber.compareAnswer("1234"));
		assertEquals("1A0B", guessNumber.compareAnswer("1567"));
		assertEquals("0A2B", guessNumber.compareAnswer("2478"));
		assertEquals("1A2B", guessNumber.compareAnswer("0324"));
		assertEquals("0A0B", guessNumber.compareAnswer("5678"));
		assertEquals("0A4B", guessNumber.compareAnswer("4321"));
	}
}
