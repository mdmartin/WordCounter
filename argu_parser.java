
class argu_parser {
	private boolean hasFile = false;
	private String myFileName = null;
	private String myDelimiters = ".?!";
	private int myLimit = 3;
	
	public boolean feedArguments(String[] args) {
		int argLen = args.length;
		
		if (argLen > 5) // too many arguments
		{
			System.err.println("Too many arguments.");
			return false;
		}

		for (int i = 0; i < argLen;) // parse arguments. it actually only iterates the elements that have odd indices.
		{

			if (!args[i].startsWith("-")) // not -l or -d. it could only be the file name
			{
				if (args[i].endsWith(".txt") && i == (argLen - 1)) {
					setHasFile(true);
					setMyFileName(args[argLen - 1]);
					break;
				} else {
					System.err.println("Illegal file name.");
					return false;
				}
				
			}
			else if (!(args[i].equals("-d") || !(args[i].equals("-l")))) // not -d, -l, or file name
			{
				System.err.println("Illegal arguments.");
				return false;
			}
			
			else if (args[i].equals("-d")) // -d. then the next argument is the string of customized delimiters
			{
				if (i < argLen - 1) {
					
						setMyDelimiters(new String(args[i + 1]));
		
					
				
				} else {
					System.err.println("No delimiter provided. Please re-run the program with a proper delimiter argument.");
					return false;
				}
				i += 2;
				//continue;
			}
			else if (args[i].equals("-l")) // -l. then the next argument has to be an integer and is the customized limitation of word length
			{
				if (i < argLen - 1) {
					if (isInteger(args[i + 1])) {
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

	private boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
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
