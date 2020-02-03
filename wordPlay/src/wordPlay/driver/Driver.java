package wordPlay.driver;

import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import wordPlay.util.SentenceProcessor;
import wordPlay.util.WordPlayValidator;

/**
 * @author John Doe
 *
 */
public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the argument value
		 * is not given java takes the default value specified in build.xml. To avoid
		 * that, below condition is used
		 */

		if ((args.length != 3) || (args[0].equals("${arg0}")) || (args[1].equals("${arg1}"))
				|| (args[2].equals("${arg2}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}

		FileProcessor fileProcessor = new FileProcessor();
		fileProcessor.fileOpen(args[0]);
		String sentence = null;
		Results results = new Results();
		results.fileOpen(args[1]);

		while ((sentence = fileProcessor.readSentence()) != "") {
			if (WordPlayValidator.isStringValid(sentence) && sentence.equals("error")) {
				System.err.println("Invalid character in file");
				System.exit(0);
			}
			SentenceProcessor sentenceProcessor = new SentenceProcessor();
			String reversedSentence = sentenceProcessor.processSentence(sentence);

			results.writeToFile(reversedSentence);

		}

		fileProcessor.fileClose();
		results.fileClose();
		results.fileOpen(args[2]);
		results.writeToFile();
		results.fileClose();
		//System.out.println("Hello World! Lets get started with the assignment");

	}
}
