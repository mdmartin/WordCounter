
class argu_parser {
	private boolean hasFile = false;
	private String myFileName = null;
	private String myDelimiters = ".?!";
	private int myLimit = 3;
	
	
	/* Function returns if the arguments are successfully parsed
	 * @params the arguments
	 * @return if arguments are correct, return true.
	 */
	public boolean feedArguments(String[] args) {

		int argLen = args.length;
		
		if (argLen > 5) // Too many arguments. There will be at most 5 arguments
		{
			System.err.println("Too many arguments.");
			return false;
		}

		for (int i = 0; i < argLen;) // Parse arguments. It actually only iterates the elements that have odd indices.
		{
			if (!args[i].startsWith("-")) // If it is not -l or -d, then it could only be a file's name.
			{
				if (args[i].endsWith(".txt") && i == (argLen - 1)) { // Only .txt file is acceptable
					setHasFile(true);
					setMyFileName(args[argLen - 1]);
					break;
				} else {
					System.err.println("Illegal file name.");
					return false;
				}
			}
			else if (!(args[i].equals("-d") || args[i].equals("-l"))) // If it is not -d, -l, or file name, then it's an illegal argument.
			{
				System.err.println(args[i] + " Improper input argument. Please check user manual.");
				return false;
			}
			
			else if (args[i].equals("-d")) // -d. then the next argument should be a string of customized delimiters
			{
				if (i < argLen - 1) {
						String a = args[i+1];
						setMyDelimiters(a);
				} else {
					System.err.println("No delimiter provided. Please re-run the program with a proper delimiter argument.");
					return false;
				}
				i += 2;
			}
			else if (args[i].equals("-l")) // -l. then the next argument should be an integer and be the customized limitation of word length
			{
				if (i < argLen - 1) {
					if (isInteger(args[i + 1])) { // judge if the next argument is an integer
						setMyLimit(Integer.valueOf(args[i + 1]));
					} else {
						System.err.println("Invalid Integer argument as the word length limitation. Please re-run the program with a proper integer.");
						return false;
					}
				} else {
					System.err.println("No integer argument for word length limitation provided. Please re-run the program with a proper integer.");
					return false;
				}
				i += 2;
			}
		}
		return true;
	}

	/* Function returns if a string could be parsed as an integer
	 * @params a string
	 * @return if the string could be parsed as an integer, return true.
	 */
	private boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	// setters and getters
	
	public boolean isHasFile() {
		return hasFile;
	}

	public void setHasFile(boolean hasFile) {
		this.hasFile = hasFile;
	}

	public String getMyFileName() {
		return myFileName;
	}

	public void setMyFileName(String myFileName) {
		this.myFileName = myFileName;
	}

	public String getMyDelimiters() {
		return myDelimiters;
	}

	public void setMyDelimiters(String myDelimiters) {
		this.myDelimiters = myDelimiters;
	}

	public int getMyLimit() {
		return myLimit;
	}

	public void setMyLimit(int myLimit) {
		this.myLimit = myLimit;
	}
}
