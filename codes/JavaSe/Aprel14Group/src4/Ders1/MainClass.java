package Ders1;

public class MainClass {

	public static void main(String[] args) {

		CheckRange checkRange = new CheckRange();

		try {
			checkRange.checkValueRange(5);
		} catch (OutOfRangeValueException e) {
			System.out.println(e.getMessage());
		}
	}
}
