/*This program will output the average number of words
 * per sentence in a give file or from standard input.
 * The sentence can be parsed by any delimiter provided, and will
 * only count words of a specified length.
 * The standard delimiters are .!?
 * The standard word length will be 3 characters
 * 
 * @authors Kunal Patel, Daniel Bennett, Paul Bernier, Gino Le Pallec 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class word_counter {
	public static void main(String[] args) {

		argu_parser parser = new argu_parser();
		if (parser.feedArguments(args)) // the parser for arguments
		{
			boolean hasFile = parser.isHasFile();
			String myFileName = parser.getMyFileName();
			String myDelimiters = parser.getMyDelimiters();
			int myLimit = parser.getMyLimit();

			Scanner sc = null;
			if (!hasFile) {
				sc = new Scanner(System.in);
			} else {
				try {
					sc = new Scanner(new File(myFileName));
				} catch (FileNotFoundException e) {
					// file not found exception
					System.err.println("File " + myFileName
							+ " does not exist.");
					return;
				}
			}
			double total_words = 0;
			double number_sentences = 0;

			sc.useDelimiter("[" + myDelimiters + "]");
			//Continue reading from file or input until the end of the file or from standard input
			
			while (sc.hasNext()) {
				String thisString = sc.next();
				thisString = thisString.trim(); //Removes unwanted spaces at the beginning or end of the sentence
				System.out.println(thisString);
				if (!thisString.equals("\\s+") && !thisString.equals("")) //Does not add 1 to count if there is simply empty space
					number_sentences++;
				
				thisString = thisString.replaceAll("\\s+", " "); //Replaces multiple spaces with one
				total_words += num_words(thisString, myLimit);
			}
			//Checks to see if there were any sentences in the input or not
			if (number_sentences == 0) {
				System.out.println("There were no sentences given");
				System.out.println("Thus the average number of words is 0");
			} else {
				System.out
						.print("The average number of words per sentence is: ");
				System.out.println(total_words / number_sentences);
			}
		}

	}
	/* Function returns the numbers of words in the sentence
	 * @params the sentence, and the an integer for the proper word_length to be counted as a word
	 * @return number of words in the sentence that are greater than or equal to the word_length
	 */
	public static int num_words(String sentence, int word_length) {
		int count = 0;
		sentence = sentence.replaceAll("[^a-zA-Z0-9\\s]", ""); // trims
																// punctuation
		String[] array = sentence.trim().split(" ");
		for (String s : array) {
			if (s.length() >= word_length && s.length() != 0) {
				count++;
			}
		}
		return count;
	}

}
