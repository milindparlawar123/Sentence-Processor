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
	 * @throws ExceptionHandler
	 */
	public void openFile(String fName) {
		file = new File(fName);
		try {
			fileReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.err.println(Constants.ERROR_OPENING_FILE);
			e.printStackTrace();
			System.exit(0);

		} finally {

		}
	}

	/**
	 * @return to check whether file is empty or not if empty it will return true
	 *         else false
	 */
	public boolean isFileEmpty() {

		if (this.file.length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * In this method, will read character till period and if there is any invalid
	 * character then will stop further reading and return string as error
	 * 
	 * @return whatever read till period will be returned
	 * @throws ExceptionHandler
	 */
	public String readSentence() {
		int readChar = 0;
		String readSentence = "";
		try {
			while ((readChar = fileReader.read()) != -1) {
				readSentence += (char) readChar;
				if (!WordPlayValidator.isCharValid(readChar)) {
					return Constants.ERROR;
				}
				if ((char) readChar == '.') {
					return readSentence;
				}
			}
		} catch (IOException e) {
			System.err.println(Constants.ERROR_READING_FILE);
			e.printStackTrace();
			System.exit(0);
		} finally {

		}
		return readSentence;
	}

	/**
	 * Closes the stream and releases any system resources associated with
	 * fileReader.
	 * 
	 * @throws ExceptionHandler
	 */
	public void fileClose() {
		try {
			fileReader.close();
		} catch (IOException e) {
			System.err.print(Constants.ERROR_CLOSING_FILE);
			e.printStackTrace();
			System.exit(0);

		} finally {

		}
	}

	@Override
	public String toString() {
		return "FileProcessor [file=" + file + ", fileReader=" + fileReader + "]";
	}

}
