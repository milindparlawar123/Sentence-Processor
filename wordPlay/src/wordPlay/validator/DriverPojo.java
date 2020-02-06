package wordPlay.validator;
import java.util.Arrays;

import wordPlay.util.Constants;

/**
 * @author Milind
 *
 */
public class DriverPojo {
	private int argsLength;
	private String args[];

	private static class ValidatorFetcher {
		public static Validator argsLengthValidator(DriverPojo d) {
			return new Validator() {
				@Override
				public void run() throws Exception {
					if (d.getArgsLength() != 3) {
						throw new Exception(Constants.ERROR_INVALID_ARGUMENTS);
					}
				}
			};
		}

		public static Validator argsValidator(DriverPojo d) {
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

	public DriverPojo(int argsLength, String[] args) throws Exception {
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
