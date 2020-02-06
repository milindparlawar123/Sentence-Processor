package wordPlay.util;

/**
 * @author Milind This class is to process sentence
 *
 */
public class SentenceProcessor {

	/**
	 * Basically this method for to process sentence. For example : it will break
	 * one sentence into 2 if there is new line in sentence and does processing like
	 * reversing
	 * 
	 * @param sentence incoming sentence which contains sentence till period
	 * @return it will return sentence with revered words in it
	 */
	public String processSentence(String sentence) {
		String reversedSentence = "";
		MatricCalculator matricCalculator = new MatricCalculator();
		matricCalculator.sentenceCounter();
		//\r\n for windows and \n for Linux OS
		if (sentence.contains("\r\n") || sentence.contains("\n")) {
			String[] list = null;
			if (sentence.contains("\r\n"))
				list = sentence.split("\r\n");
			else if (sentence.contains("\n")) {
				list = sentence.split("\n");
			}
			int senCnt = 0;
			for (String sen : list) {
				matricCalculator.matrixCalProcess(sen);
				reversedSentence += getReversedSentence(sen);

				if (senCnt < list.length - 1) {
					reversedSentence += "\n";
				}
				senCnt++;
			}
		} else {
			matricCalculator.matrixCalProcess(sentence);
			reversedSentence = getReversedSentence(sentence);
		}
		return reversedSentence;
	}

	/**
	 * @param sentence incoming sentence from process sentence method
	 * @return it will return sentence with words reversed in it
	 */
	public String getReversedSentence(String sentence) {
		String words[] = sentence.split(" ");

		String reversedStr = "";
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			String temp = "";
			if (word.contentEquals("")) {
				continue;
			}
			temp = reverseWord(word);

			if (temp.length() != 0 && temp.charAt(0) == '.') {
				temp = temp.substring(1) + '.';
			}
			reversedStr += temp + " ";
		}
		return reversedStr;

	}

	/**
	 * @param word incoming word
	 * @return it will return reverse of word
	 */
	private static String reverseWord(String word) {
		String reversedWord = "";
		for (int j = word.length() - 1; j >= 0; j--) {
			//int c = word.charAt(j);
			reversedWord = reversedWord + word.charAt(j);
		}
		return reversedWord;
	}

	@Override
	public String toString() {
		return "SentenceProcessor []";
	}

}
