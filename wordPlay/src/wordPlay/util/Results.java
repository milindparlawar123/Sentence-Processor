package wordPlay.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	public void fileOpen(String fName) {
		file = new File(fName);
		try {
			fileWriter = new BufferedWriter(new FileWriter(file));

		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}

	}

	/**
	 * this method is to write AVG_NUMBER_WORDS_PER_SENTENCE ,
	 * AVG_NUM_CHARS_PER_SENTENCE, MAX_FREQ_WORD and LONGEST_WORD to metrics output
	 * file
	 */
	@Override
	public void writeToFile() {
		MatricCalculator matricCalculator = new MatricCalculator();
		try {

			fileWriter
					.write("AVG_NUMBER_WORDS_PER_SENTENCE = "
							+ String.format("%.2f",
									(float) matricCalculator.getTotalWordCount() / matricCalculator.getTotalSenCount())
							+ "\n");
			fileWriter
					.write("AVG_NUM_CHARS_PER_SENTENCE = "
							+ String.format("%.2f",
									(float) matricCalculator.getTotalCharCount() / matricCalculator.getTotalSenCount())
							+ "\n");
			fileWriter.write("MAX_FREQ_WORD = " + matricCalculator.getMaxFreqWord() + "\n");
			fileWriter.write("LONGEST_WORD = " + matricCalculator.getLongestWord());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return "Results [file=" + file + ", fileWriter=" + fileWriter + "]";
	}

}
