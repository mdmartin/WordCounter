import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class word_counter {
	public static void main(String[] args) {
		
		// I'm currently setting all variables and functions in argu_parser as static variables and functions. What do you think about this implementation??
		
		argu_parser.feedArguments(args); // the parser for arguments
		

		boolean hasDelimiter = argu_parser.isHasDelimiter();
		boolean hasFile = argu_parser.isHasFile();
		String myFileName = argu_parser.getMyFileName();
		String myDelimiters = argu_parser.getMyDelimiters();
		int myLimit = argu_parser.getMyLimit();
		
		Scanner sc = null;
		if (!hasFile)
		{
			sc = new Scanner(System.in);
		}
		else
		{
			try {
				sc = new Scanner(new File(myFileName));
			} catch (FileNotFoundException e) {
				// file not found exception
				e.printStackTrace();
			}
		}
		double total_words = 0;
		double number_sentences = 0;
		
		if (hasDelimiter)
		{
			sc.useDelimiter("[" + myDelimiters + "]");
		}
		else
		{
			// Default delimiters
			sc.useDelimiter("[\\.\\?\\!]");
		}
		
		while (sc.hasNext()) 
		{
			String thisString = sc.next();
			total_words += num_words(thisString, myLimit);
			number_sentences++;
		}
		
		System.out.println("The number of sentences is: " + number_sentences);
		System.out.print("The average number of words per sentence is: ");
		System.out.println(total_words / number_sentences);
		
	}

	
	
	private static int num_words(String sentence, int word_length) {
		int count = 0;
		String[] array = sentence.trim().split(" ");
		for (String s : array) 
		{
			s = s.replaceAll("[^a-zA-Z0-9]", ""); // trim the punctuation. like "code," -> "code"
			if (s.length() >= word_length)
			{
				System.out.println(s);
				count++;
			}
		}
		return count;
	}

}
