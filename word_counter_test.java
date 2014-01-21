import static org.junit.Assert.*;

import org.junit.Test;


public class word_counter_test {

	@Test
	public void isWorkingForNormalSentence() {
		assertEquals(4, word_counter.num_words("Hello this sentence should have only 4 words", 5));
	}
	
	@Test
	public void isWorkingWithSemiColon() {
		assertEquals(4, word_counter.num_words("Hello; this sentence should have only 4 words", 5));
	}
	
	@Test
	public void isWorkingWithEndOfLine() {
		assertEquals(7, word_counter.num_words("Hello \n this sentence should have only 4 words", 4));
	}
	
	@Test
	public void isWorkingwithNullSentence() {
		assertEquals(0, word_counter.num_words("", 0)); //even if word length is 0, we should get 0 words in this 
	}													// sentence
}
