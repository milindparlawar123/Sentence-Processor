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

	@Override
	public void fileOpen(String fName) {
		// String fileName = "C:\\Users\\Anand\\Pictures\\DP\\" + fName;
		file = new File(fName);
		try {
			fileWriter = new BufferedWriter(new FileWriter(file));

		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void fileClose() {
		try {
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void writeToFile(String s) {

		try {
			fileWriter.write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void writeToFile() {
		MatricCalculator matricCalculator = new MatricCalculator();
//System.out.println(matricCalculator.getTotalSenCount() + " << "+ matricCalculator.getTotalWordCount() +">> "+ matricCalculator.getTotalCharCount());

		try {
			// BufferedWriter writerMetrics = new BufferedWriter(
			// new FileWriter("C:\\Users\\Anand\\Pictures\\DP\\MILINDMetricsOutput.txt"));
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
			// fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
