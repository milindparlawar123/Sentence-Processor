package wordPlay.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
	private File file;
	private BufferedReader fileReader;

	public FileProcessor() {
	}

	public void fileOpen(String fName) {
		// String fileName="C:\\Users\\Anand\\Pictures\\DP\\" + fName;

		file = new File(fName);
		try {
			fileReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String readSentence() {
		int readChar = 0;
		String readSentence = "";
		try {
			while ((readChar = fileReader.read()) != -1) {
				readSentence += (char) readChar;
				if ((char) readChar == '.') {
					return readSentence;
					// SentenceProcessor sentenceProcessor = new SentenceProcessor();
					// Results results = new Results();
					// String temp=sentenceProcessor.processSentence(readSentence);
					// System.out.print(temp);
					// readSentence="";
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public void fileClose() {
		try {
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
