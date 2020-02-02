package wordPlay.util;

public class SentenceProcessor {

	public String processSentence(String sentence) {
		String reversedSentence = "";
		MatricCalculator matricCalculator = new MatricCalculator();
		matricCalculator.sentenceCounter();
		if (sentence.contains("\r\n") || sentence.contains("\n")) {
			// cCount++;
			String[] list = null;
			if (sentence.contains("\r\n"))
				list = sentence.split("\r\n");
			else if (sentence.contains("\n")) {
				list = sentence.split("\n");
			}

			String sentence1 = getReversedSentence(list[0]);

			matricCalculator.matrixCalProcess(list[0]);
			String sentence2 = getReversedSentence(list[1]);
			matricCalculator.matrixCalProcess(list[1]);
			reversedSentence = sentence1 + "\n" + sentence2;
			/// writer.write(prin + "\n" + prin2);
			// System.out.print(prin + "\n" + prin2);
			/// abc = "";
		} else {
			matricCalculator.matrixCalProcess(sentence);
			reversedSentence = getReversedSentence(sentence);
			// writer.write(prin);
			// System.out.print(prin);
			// abc = "";
		}
		return reversedSentence;
	}

	public String getReversedSentence(String sentence) {
		// MatricCalculator matricCalculator = new MatricCalculator();
		// charCount(sentence);
		String words[] = sentence.split(" ");
		// countChar += s.length();
		/// countWord += temp.length;
		String reversedStr = "";
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			String temp = "";
			if (word.contentEquals("")) {
				// countWord -= 1;
				continue;
			}
			temp = reverseWord(word);
			// longestWord(word);
			// storeWordsInMap(word);
			if (temp.length() != 0 && temp.charAt(0) == '.') {
				temp = temp.substring(1) + '.';
			}
			reversedStr += temp + " ";
			// reversedStr+= (i < words.length-1)? temp + " ":temp;
		}
		return reversedStr;

	}

	private static String reverseWord(String word) {
		String reversedWord = "";
		for (int j = word.length() - 1; j >= 0; j--) {
			int c = word.charAt(j);
			reversedWord = reversedWord + word.charAt(j);
		}
		return reversedWord;
	}

}
