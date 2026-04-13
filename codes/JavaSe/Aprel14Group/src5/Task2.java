import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Task2 {

	public static boolean isValidDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		try {
			LocalDate.parse(date, formatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(isValidDate("31-12-2024"));
		System.out.println(isValidDate("32-12-2024"));
	}
}