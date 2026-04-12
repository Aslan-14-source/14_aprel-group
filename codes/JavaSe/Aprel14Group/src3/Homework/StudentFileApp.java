package Homework;

import java.io.*;
import java.util.Scanner;

public class StudentFileApp {
	public static void main(String[] args) {
		try {
			File folder = new File("student_data");
			if (!folder.exists()) {
				folder.mkdir();
				System.out.println("Folder yaradıldı.");
			}

			File file = new File(folder, "info.txt");
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("Fayl yaradıldı.");
			}

			Scanner scanner = new Scanner(System.in);

			System.out.print("Ad daxil edin: ");
			String ad = scanner.nextLine();

			System.out.print("Soyad daxil edin: ");
			String soyad = scanner.nextLine();

			System.out.print("Yaş daxil edin: ");
			int yas = scanner.nextInt();

			FileWriter writer = new FileWriter(file);
			writer.write("Ad: " + ad + "\n");
			writer.write("Soyad: " + soyad + "\n");
			writer.write("Yaş: " + yas + "\n");
			writer.close();

			System.out.println("Məlumat fayla yazıldı.");

			System.out.println("\nFayldan oxunan məlumat:");

			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;

			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();

			System.out.print("\nFaylı silmək istəyirsiniz? (bəli/xeyr): ");
			scanner.nextLine();
			String cavab = scanner.nextLine();

			if (cavab.equalsIgnoreCase("bəli")) {
				if (file.delete()) {
					System.out.println("Fayl silindi.");
				} else {
					System.out.println("Fayl silinmədi.");
				}

				if (folder.delete()) {
					System.out.println("Folder silindi.");
				}
			}

			scanner.close();

		} catch (IOException e) {
			System.out.println("Xəta baş verdi: " + e.getMessage());
		}	
	}
}