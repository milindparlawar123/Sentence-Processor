package wordPlay.validator;
import java.util.Arrays;

import wordPlay.util.Constants;

/**
 * @author Milind
 *        below class is to validate arguments provided to driver class
 */
public class DriverValidator {
	private int argsLength;
	private String args[];

	private static class ValidatorFetcher {
		
		/**
		 * @param d it is the object of Driver class
		 * @return run method will check whether there are 3 
		 * arguments present or not. if not it will throw error else
		 * will return to calling method 
		 */
		public static Validator argsLengthValidator(DriverValidator d) {
			return new Validator() {
				@Override
				public void run() throws Exception {
					if (d.getArgsLength() != 3) {
						throw new Exception(Constants.ERROR_INVALID_ARGUMENTS);
					}
				}
			};
		}

		/**
		 * @param d it is the object of Driver class
		 * @return run method will check whether all inputs file provided or not
		 * and it will also check that 2 files path and names are not same
		 */
		public static Validator argsValidator(DriverValidator d) {
			return new Validator() {
				@Override
				public void run() throws Exception {
					if ((d.getArgs()[0].equals("${arg0}")) || (d.getArgs()[1].equals("${arg1}"))
							|| (d.getArgs()[2].equals("${arg2}"))) {
						throw new Exception(Constants.ERROR_ALL_ARG_FILES_REQUIRED);
					}else if((d.getArgs()[0].equals(d.getArgs()[1])) || (d.getArgs()[1].equals(d.getArgs()[2]))
							&& !(d.getArgs()[2].equals(d.getArgs()[0]))) {
						throw new Exception(Constants.ERROR_DUPLICATE_FILES);						
					}
				}
			};
		}
	}

	public DriverValidator(int argsLength, String[] args) throws Exception {
		this.argsLength = argsLength;
		this.args = args;

		ValidatorUtil.validate("failed", ValidatorFetcher.argsLengthValidator(this),
				ValidatorFetcher.argsValidator(this));
	}

	public int getArgsLength() {
		return argsLength;
	}

	public void setArgsLength(int argsLength) {
		this.argsLength = argsLength;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	@Override
	public String toString() {
		return "Driver [argsLength=" + argsLength + ", args=" + Arrays.toString(args) + "]";
	}

}
