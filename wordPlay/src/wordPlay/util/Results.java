package wordPlay.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Milind 
 *         below class is to write reversed sentences to output file. And
 *         AVG_NUMBER_WORDS_PER_SENTENCE, AVG_NUM_CHARS_PER_SENTENCE,
 *         MAX_FREQ_WORD and LONGEST_WORD to metrics file.
 *
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	private File file;
	private BufferedWriter fileWriter;

	public Results() {
	}

	/**
	 * @param fName incoming file name this method will open fName file if not
	 *              present then it will create new file with name fName
	 */
	@Override
	public void openFile(String fName) {
		file = new File(fName);
		try {
			fileWriter = new BufferedWriter(new FileWriter(file));

		} catch (IOException e) {
			System.err.println(Constants.ERROR_OPENING_FILE);
			e.printStackTrace();
			System.exit(0);
		} finally {

		}

	}

	/**
	 * Closes the stream and releases any system resources associated with
	 * fileWriter.
	 */
	@Override
	public void fileClose() {
		try {
			fileWriter.close();
		} catch (IOException e) {
			System.err.print(Constants.ERROR_CLOSING_FILE);
			e.printStackTrace();
			System.exit(0);
		} finally {

		}
	}

	/**
	 * @param s s is sentence which will be written to output file.
	 */
	@Override
	public void writeToFile(String s) {

		try {
			fileWriter.write(s);
		} catch (IOException e) {
			System.err.println(Constants.ERROR_WRITING_FILE);
			e.printStackTrace();
			System.exit(0);
		} finally {

		}

	}

	/**
	 * this method is to write AVG_NUMBER_WORDS_PER_SENTENCE ,
	 * AVG_NUM_CHARS_PER_SENTENCE, MAX_FREQ_WORD and LONGEST_WORD to metrics output
	 * file
	 * @throws ExceptionHandler 
	 */
	@Override
	public void writeToFile() {
		MatricCalculator matricCalculator = new MatricCalculator();
		try {

			fileWriter
					.write(Constants.AVG_NUMBER_WORDS_PER_SENTENCE + " = "
							+ String.format(Constants.ROUND_TO_TWO_DECIMAL,
									(float) matricCalculator.getTotalWordCount() / matricCalculator.getTotalSenCount())
							+ Constants.NEW_LINE);
			fileWriter
					.write(Constants.AVG_NUM_CHARS_PER_SENTENCE + " = "
							+ String.format(Constants.ROUND_TO_TWO_DECIMAL,
									(float) matricCalculator.getTotalCharCount() / matricCalculator.getTotalSenCount())
							+ Constants.NEW_LINE);
			fileWriter.write(Constants.MAX_FREQ_WORD + " = " + matricCalculator.getMaxFreqWord() + Constants.NEW_LINE);
			fileWriter.write(Constants.LONGEST_WORD + " = " + matricCalculator.getLongestWord());
		} catch (IOException e) {
			System.err.println(Constants.ERROR_WRITING_FILE);
			e.printStackTrace();
			System.exit(0);
		} finally {

		}

	}

	@Override
	public String toString() {
		return "Results [file=" + file + ", fileWriter=" + fileWriter + "]";
	}

}
