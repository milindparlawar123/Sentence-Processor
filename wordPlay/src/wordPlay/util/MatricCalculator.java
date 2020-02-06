package wordPlay.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Milind
 * below class is to calculate number of 
 * words, chars and sentences
 *
 */
public class MatricCalculator {

	/**
	 * countWord is to keep count of number of words in a file
	 */
	private static int countWord = 0;
	/**
	 * countChar is to keep count number of characters in a file
	 */
	private static int countChar = 0;
	/**
	 * countSen is to keep count of sentences in a file
	 */
	private static int countSen = 0;
	/**
	 * map is for to store word and its frequency
	 */
	private static Map<String, Integer> map = new HashMap<String, Integer>();

	/**
	 * @return it will return total words count
	 */
	public int getTotalWordCount() {
		return countWord;
	}

	/**
	 * @return it will return total chars count
	 */
	public int getTotalCharCount() {
		return countChar;
	}

	/**
	 * @return it will return total sentences count
	 */
	public int getTotalSenCount() {
		return countSen;
	}

	/**
	 * this method is to keep count of sentences whenever below method gets called
	 * sentence counter gets increased by one
	 */
	public void sentenceCounter() {
		this.countSen++;
	}

	/*
	 * public int getAvgNumOfCharsPerSen() { return countChar / countSen; }
	 */

	/**
	 * @param sentence incoming sentence below method is to store words in map and
	 *                 count words and to call other methods
	 */
	public void matrixCalProcess(String sentence) {
		charCount(sentence);
		String words[] = sentence.split(" ");
		countWord += words.length;
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (word.contentEquals("")) {
				countWord -= 1;
				continue;
			}
			storeWordsInMap(word.toLowerCase());
		}
	}

	/**
	 * @param s incoming sentence below method to calculate number of characters in
	 *          sentence and also it will check whether character is valid or not
	 */
	private static void charCount(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (isCharValid(s, i)) {
				countChar++;
			}
		}
	}

	/**
	 * @return below method will return maximum frequency word
	 */
	public String getMaxFreqWord() {

		int maxValInMap = 0;
		String mKey = null;
		for (String key : map.keySet()) {
			if (map.get(key) > maxValInMap) {
				maxValInMap = map.get(key);
				mKey = key;
			}
		}
		return mKey;
	}

	/**
	 * @return below method will return longest word
	 */
	public String getLongestWord() {

		String longestWord = "";

		for (String key : map.keySet()) {
			if (key.length() > longestWord.length()) {
				longestWord = key;
			}
		}
		return longestWord;

	}

	/**
	 * @param s incoming word below method is to store words and its frequency in
	 *          HashMap
	 */
	private static void storeWordsInMap(String s) {
		if (s.contains(".")) {
			s = s.substring(0, s.length() - 1);
		}
		if (map.get(s) != null) {
			map.put(s, map.get(s).intValue() + 1);
		} else
			map.put(s, 1);
	}

	/**
	 * @param s incoming sentence
	 * @param i index of character in sentence
	 * @return it will return true if character satisfies below conditions else
	 *         false
	 */
	private static boolean isCharValid(String s, int i) {
		return (s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122)
				|| (s.charAt(i) >= 48 && s.charAt(i) <= 57)
				|| (s.charAt(i) == ' ' || s.charAt(i) == '.' || s.charAt(i) == ' ') || (s.charAt(i) == '\n');
	}

	@Override
	public String toString() {
		return "MatricCalculator []";
	}

}
