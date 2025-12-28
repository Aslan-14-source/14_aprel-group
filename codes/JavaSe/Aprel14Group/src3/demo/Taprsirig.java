package demo;
import java.util.Scanner;
public class Taprsirig {
	 public static void main(String[] args) {

	        Scanner input = new Scanner(System.in);

	        System.out.print("Yaşınızı daxil edin: ");
	        int yas = input.nextInt();

	        String mesaj = (yas < 18) ? "Access denied" : "Access granted";

	        System.out.println(mesaj);

	        input.close();
	    }

}
