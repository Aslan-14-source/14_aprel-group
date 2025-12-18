package Src;
import java.util.Random;
public class Task {


	    public static void main(String[] args) {

	        char[] chars = {'A', 's', 'l', 'a', 'n'};
	        String result = new String(chars);
	        System.out.println("1) String: " + result);

	        String str1 = "Abc";
	        boolean onlyThreeLetters = str1.matches("[A-Za-z]{3}");
	        System.out.println("2) 3 simvol & ingilis əlifbası: " + onlyThreeLetters);

	        String str2 = "";
	        boolean isEmpty = str2.isEmpty();
	        System.out.println("3) Boşdur: " + isEmpty);

	        boolean ends = endsWithCheck("HelloWorld", "World");
	        System.out.println("4) Bitir: " + ends);

	        Random random = new Random();
	        int randomNumber = random.nextInt(21) + 10; // 10–30
	        System.out.println("5) Təsadüfi ədəd: " + randomNumber);

	        double number = 12.34567;
	        double rounded = Math.round(number * 100.0) / 100.0;
	        System.out.println("6) Yuvarlaqlaşdırılmış: " + rounded);
	    }
	    public static boolean endsWithCheck(String a, String b) {
	        return a.endsWith(b);
	    }
	}


