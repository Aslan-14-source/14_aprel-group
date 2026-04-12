package devsys;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task {

	public static void main(String[] args) {
	        try {

	            File folder = new File("myFolder");
	            if (!folder.exists()) {
	                folder.mkdir();
	            }

	            File file = new File(folder, "qeyd.txt");

	            if (file.exists()) {
	                System.out.println("Fayl artıq var");
	            } else {
	                file.createNewFile();
	                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	                writer.write("Java-da fayllarla işləmək maraqlıdır!");
	                writer.close();

	                System.out.println("Fayl yaradıldı və məlumat yazıldı");
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
