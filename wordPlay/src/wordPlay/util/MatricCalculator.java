package wordPlay.util;

import java.util.HashMap;
import java.util.Map;

public class MatricCalculator {
	private static int countWord = 0;
	private static int countChar = 0;
	private static String longestWord = "";
	private static int countSen = 0;
	private static Map<String, Integer> map = new HashMap<String, Integer>();

	public int getAvgNumOfWordsPerSen() {
		return countWord / countSen;
	}

	public int getTotalWordCount() {
		return countWord;
	}

	public int getTotalCharCount() {
		return countChar;
	}

	public int getTotalSenCount() {
		return countSen;
	}

	public void sentenceCounter() {
		this.countSen++;
	}

	public int getAvgNumOfCharsPerSen() {
		return countChar / countSen;
	}

	public void matrixCalProcess(String sentence) {
		charCount(sentence);
		// TODO Auto-generated method stub

		// charCount(s);
		String words[] = sentence.split(" ");
		// countChar += s.length();
		countWord += words.length;
		// String reversedStr = "";
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			// String temp1 = "";
			if (word.contentEquals("")) {
				countWord -= 1;
				continue;
			}
			// temp1 = reverse(word);
			// longestWord(word);
			storeWordsInMap(word);

		}
		// return reversedStr;

	}

	private static void charCount(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (isCharValid(s, i)) {
				// System.out.print(s.charAt(i));
				countChar++;
			}
		}
	}

	public String getMaxFreqWord() {

		int maxValInMap = 0; // This will return max value in the Hashmap
		String mKey = null;
		for (String key : map.keySet()) {
			if (map.get(key) > maxValInMap) {
				maxValInMap = map.get(key);
				mKey = key;
			}
		}
		return mKey;

		// return "";
	}

	public String getLongestWord() {

		String longestWord = ""; // This will return max value in the Hashmap
		// String mKey = null;
		for (String key : map.keySet()) {
			if (key.length() > longestWord.length()) {
				longestWord = key;
				/// mKey = key;
			}
		}
		return longestWord;

		// return "";
	}

	public static void storeWordsInMap(String s) {
		if (s.contains(".")) {
			s = s.substring(0, s.length() - 1);
		}
		if (map.get(s) != null) {
			map.put(s, map.get(s).intValue() + 1);
		} else
			map.put(s, 1);
	}

	private static boolean isCharValid(String s, int i) {
		return (s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122)
				|| (s.charAt(i) >= 48 && s.charAt(i) <= 57)
				|| (s.charAt(i) == ' ' || s.charAt(i) == '.' || s.charAt(i) == ' ') || (s.charAt(i) == '\n');
	}

}
