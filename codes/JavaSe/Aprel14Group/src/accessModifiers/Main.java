package accessModifiers;

public class Main {

	enum Days {
		BAZAR_ERTESI, CERSENBE_AXSAMI, CERSENBE, CUME_AXSAMI, CUME, SENBE, BAZAR
	}

	public static void main(String[] args) {

		String word = "salam";
		String reversed = "";

		for (int i = word.length() - 1; i >= 0; i--) {
			reversed = reversed + word.charAt(i);
		}

		System.out.println("Tərsinə çevrilmiş söz: " + reversed);

		Scanner scanner = new Scanner(System.in);

		System.out.println("Gün daxil edin (məs: CUME, SENBE): ");
		String input = scanner.nextLine();

		Days day = Days.valueOf(input);

		if (day == Days.CUME || day == Days.SENBE) {
			System.out.println("Bu gün istirahət günüdür");
		} else {
			System.out.println("Bu gün dərs günüdür");
		}
	}
}
