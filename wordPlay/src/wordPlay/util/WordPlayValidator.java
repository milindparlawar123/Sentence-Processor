package wordPlay.util;

/**
 * @author Milind this class is for validation
 *
 */
public class WordPlayValidator {

	/**
	 * @param s incoming string value
	 * @return if string is not null then return true else false
	 */
	public static boolean isStringValid(String s) {
		if (s == null) {
			return false;
		}
		return true;
	}

	/**
	 * @param c incoming character
	 * @return if character is valid then return true else false
	 */
	public static boolean isCharValid(int c) {
		if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57) || (c == ' ' || c == '.' || c == '\r')
				|| (c == '\n')) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "WordPlayValidator []";
	}

}
