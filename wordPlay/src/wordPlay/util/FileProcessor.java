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

	/**
	 * @param fName incoming file name this method will open fName file
	 */
	public void fileOpen(String fName) {
		file = new File(fName);
		try {
			fileReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error: file not found. Please enter correct file name as input.txt");
			System.exit(0);
		}
	}

	/**
	 * In this method, will read character till period and if there is any invalid
	 * character then will stop further reading and return string as error
	 * 
	 * @return whatever read till period will be returned
	 */
	public String readSentence() {
		int readChar = 0;
		String readSentence = "";
		try {
			while ((readChar = fileReader.read()) != -1) {
				readSentence += (char) readChar;
				if (!WordPlayValidator.isCharValid(readChar)) {
					return "error";
				}
				if ((char) readChar == '.') {
					return readSentence;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readSentence;
	}

	/**
	 * Closes the stream and releases any system resources associated with
	 * fileReader.
	 */
	public void fileClose() {
		try {
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}

	@Override
	public String toString() {
		return "FileProcessor [file=" + file + ", fileReader=" + fileReader + "]";
	}

}
