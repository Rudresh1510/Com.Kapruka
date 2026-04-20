package kapruka.exceptions;

public class InvalidBrowserNameException extends RuntimeException{

private String browserName;
	
	public InvalidBrowserNameException(String browserName) {
		this.browserName = browserName;
	}
	
	@Override
		public String getMessage() {
			return this.browserName+" browser is not supported";
		}
}
