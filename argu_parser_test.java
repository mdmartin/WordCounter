import static org.junit.Assert.*;

import org.junit.Test;

public class argu_parser_test {

	@Test
	public void testFeedArgumentsGoodOption() {
		argu_parser parser = new argu_parser();
		String[] args = {"test.txt"};
		assertTrue(parser.feedArguments(args));
	}
	
	@Test
	public void testFeedArgumentsGoodOption2() {
		argu_parser parser = new argu_parser();
		String[] args = {"-d", ".!;?", "test.txt"};
		assertTrue(parser.feedArguments(args));
	}
	
	@Test
	public void testFeedArgumentsGoodOption3() {
		argu_parser parser = new argu_parser();
		String[] args = {"-l", "1", "test.txt"};
		assertTrue(parser.feedArguments(args));
	}
	
	@Test
	public void testFeedArgumentsGoodOption4() {
		argu_parser parser = new argu_parser();
		String[] args = {"-d", ".!;?", "-l", "2", "test.txt"};
		assertTrue(parser.feedArguments(args));
	}
	
	@Test
	public void testFeedArgumentsDefaultDelimiters() {
		argu_parser parser = new argu_parser();
		String[] args = {};
		assertTrue(parser.feedArguments(args));
		assertEquals(".?!", parser.getMyDelimiters());
	}
	
	@Test
	public void testFeedArgumentsBadOptions() {
		argu_parser parser = new argu_parser();
		String[] args = {"-d", "-l", "5"};
		assertFalse(parser.feedArguments(args));
	}
	
	@Test
	public void testFeedArgumentsBadOptions2() {
		argu_parser parser = new argu_parser();
		String[] args = {"-l", "-d", ".?!"};
		assertFalse(parser.feedArguments(args));
	}
	
	@Test
	public void testFeedArgumentsBadOptions3() {
		argu_parser parser = new argu_parser();
		String[] args = {"-l", "not integer"};
		assertFalse(parser.feedArguments(args));
	}
	
	@Test
	public void testFeedArgumentsEmptySetOfDelimited() {
		argu_parser parser = new argu_parser();
		String[] args = {"-d", ""};
		assertTrue(parser.feedArguments(args));
	}
	
	@Test
	public void testFeedArgumentsDefaultWordLength() {
		argu_parser parser = new argu_parser();
		String[] args = {};
		assertTrue(parser.feedArguments(args));
		assertEquals(3, parser.getMyLimit());
	}
	
	@Test
	public void testFeedArgumentsWithSemicolon() {
		argu_parser parser = new argu_parser();
		String[] args = {"-d", ";.!?"};
		assertTrue(parser.feedArguments(args));
		assertEquals(";.!?", parser.getMyDelimiters());
	}
	
	@Test
	public void testFeedArgumentsWordLength() {
		argu_parser parser = new argu_parser();
		String[] args = {"-d", ";.!?"};
		assertTrue(parser.feedArguments(args));
		assertEquals(";.!?", parser.getMyDelimiters());
	}
	
	@Test
	public void testFeedArgumentsInvalidDOption() {
		argu_parser parser = new argu_parser();
		String[] args = {"-d"};
		assertFalse(parser.feedArguments(args));
	}
	
	@Test
	public void testFeedArgumentsInvalidLOption() {
		argu_parser parser = new argu_parser();
		String[] args = {"-l"};
		assertFalse(parser.feedArguments(args));
	}

}
