package com.oocl;

import org.junit.Test;

public class RandomAnswerGeneratorTest {

	@Test
	public void should_return_random_answer() {
		RandomAnswerGenerator randomAnswerGenerator = new RandomAnswerGenerator();
		String randomAnswer = randomAnswerGenerator.generate();
		System.out.println(randomAnswer);
	}
}