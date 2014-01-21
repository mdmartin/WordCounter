import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class word_counter {
	public static void main(String[] args) {

		// I'm currently setting all variables and functions in argu_parser as
		// static variables and functions. What do you think about this


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
					System.err.println("File " + myFileName + " does not exist.");
//					e.printStackTrace();
					return;
				}
			}
			double total_words = 0;
			double number_sentences = 0;

			sc.useDelimiter("[" + myDelimiters + "]");

			while (sc.hasNext()) {
				String thisString = sc.next();
				thisString = thisString.trim();

				if (!thisString.equals("\\s+") && !thisString.equals(""))
					number_sentences++;
				thisString = thisString.replaceAll("\\s+", " ");
				total_words += num_words(thisString, myLimit);
//				System.out.println(number_sentences + " " + thisString);

				
			}

			System.out.println("The number of sentences is: "
					+ number_sentences);
			System.out.print("The average number of words per sentence is: ");
			System.out.println(total_words / number_sentences);
		}

	}

	public static int num_words(String sentence, int word_length) {
		int count = 0;
		sentence = sentence.replaceAll("[^a-zA-Z0-9\\s]", ""); //trims punctuation
		String[] array = sentence.trim().split(" ");
		for (String s : array) {
		
			if (s.length() >= word_length && s.length()!=0) {
				count++;
			}
		}
		return count;
	}

}
