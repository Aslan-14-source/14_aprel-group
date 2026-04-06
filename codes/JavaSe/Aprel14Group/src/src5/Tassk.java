package src5;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

public class Tassk {

	public static void main(String[] args) {

		LocalDateTime tarixVaxt = LocalDateTime.of(2025, 5, 10, 14, 30, 45);

		System.out.println("Tarix (raw): " + tarixVaxt);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		String formatlanmis = tarixVaxt.format(formatter);

		System.out.println("Formatlanmış tarix: " + formatlanmis);

	}
}