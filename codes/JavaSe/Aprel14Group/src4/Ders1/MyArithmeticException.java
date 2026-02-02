package Ders1;

public class MyArithmeticException extends Exception {
	private String myMessage;

	public MyArithmeticException(String message) {
		this.myMessage = message;
	}

	public String getMyMessage() {
		return myMessage;
	}
}