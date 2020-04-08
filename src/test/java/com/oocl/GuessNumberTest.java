package com.oocl;

import org.junit.Test;

public class GuessNumberTest {
	@Test
	public void should_return_random_answer() {
		GuessNumber guessNumber = new GuessNumber();

		String randomAnswer = guessNumber.generateRandomAnswer();
		System.out.println(randomAnswer);
	}
}
