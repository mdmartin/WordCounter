
class argu_parser {
	private static boolean hasDelimiter = false;
	private static boolean hasFile = false;
	private static String myFileName = null;
	private static String myDelimiters = null;
	private static int myLimit = 3;

	public static void feedArguments(String[] args)
	{
		int argLen = args.length;

		if (argLen > 5) // too many arguments
		{
			System.err.println("Too many arguments.");
			return;
		}

		for (int i = 0; i < argLen; ) // parse arguments. it actually only iterates the elements that have odd indices.
		{
			if (!args[i].startsWith("-")) // not -l or -d. it could only be the file name
			{
				if (args[i].endsWith(".txt") && i == argLen - 1)
				{
					setHasFile(true);
					setMyFileName(args[argLen - 1]);
				}
				else 
				{
					System.err.println("Illegal arguments.");
					return;
				}
			}
			if (!(args[i].equals("-d") || args[i].equals("-l"))) // not -d, -l, or file name
			{
				System.err.println("Illegal arguments.");
				return;
			}
			if (args[i].equals("-d")) // -d. then the next argument is the string of customized delimiters
			{
				setHasDelimiter(true);
				if (i < argLen - 1)
				{
					setMyDelimiters(new String(args[i + 1]));
				}
				else 
				{
					System.err.println("Illegal arguments.");
					return;
				}
				i += 2;
				continue;
			}
			if (args[i].equals("-l")) // -l. then the next argument has to be an integer and is the customized limitation of word length
			{
				if (i < argLen - 1)
				{
					if (isInteger(args[i + 1]))
					{
						setMyLimit(Integer.valueOf(args[i + 1]));
					}
					else
					{
						System.err.println("Illegal arguments.");
						return;
					}
				}
				else 
				{
					System.err.println("Illegal arguments.");
					return;
				}
				i += 2;
			}
		}
	}
	
	
	
	private static boolean isInteger(String s) {
	    try 
	    { 
	        Integer.parseInt(s); 
	    } 
	    catch(NumberFormatException e) 
	    { 
	        return false; 
	    }
	    return true;
	}



	public static boolean isHasDelimiter() {
		return hasDelimiter;
	}



	public static void setHasDelimiter(boolean hasDelimiter) {
		argu_parser.hasDelimiter = hasDelimiter;
	}



	public static boolean isHasFile() {
		return hasFile;
	}



	public static void setHasFile(boolean hasFile) {
		argu_parser.hasFile = hasFile;
	}



	public static String getMyFileName() {
		return myFileName;
	}



	public static void setMyFileName(String myFileName) {
		argu_parser.myFileName = myFileName;
	}



	public static String getMyDelimiters() {
		return myDelimiters;
	}



	public static void setMyDelimiters(String myDelimiters) {
		argu_parser.myDelimiters = myDelimiters;
	}



	public static int getMyLimit() {
		return myLimit;
	}



	public static void setMyLimit(int myLimit) {
		argu_parser.myLimit = myLimit;
	}
}
