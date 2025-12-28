package demo;


	import java.util.Scanner;

	public class Switchcase {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        // sert1
	        int yas = sc.nextInt();
	        if (yas >= 18)
	            System.out.println("Yetiskinsen");
	        else
	            System.out.println("Usaqsan");

	        //  sert2
	        int a = sc.nextInt();
	        int b = sc.nextInt();
	        if (a > b)
	            System.out.println("Birinci eded boyukdur");
	        else if (a == b)
	            System.out.println("Iki eded beraberdi");
	        else
	            System.out.println("Ikinci eded boyukdur");

	        // sert3
	        int xal = sc.nextInt();
	        if (xal >= 90)
	            System.out.println("Har iki dasdan kecmisen");
	        else if (xal >= 70)
	            System.out.println("Har iki dasdan kecmemisen");
	        else
	            System.out.println("Bir fənndan ugurla kecmisen, diger fənndan ise kesilmisen");

	        // Şərt 4
	        String gun = sc.next();
	        if (gun.equals("Senbe") || gun.equals("Bazar"))
	            System.out.println("Hafta sonu");
	        else if (gun.equals("Bazar ertesi") || gun.equals("Cumə"))
	            System.out.println("Haftanin baslangici ve sonu");
	        else
	            System.out.println("Hafta ici");

	        // Switch 1
	        int gunNo = sc.nextInt();
	        switch (gunNo) {
	            case 1 -> System.out.println("Bazar ertesi");
	            case 2 -> System.out.println("Cersenbe axsami");
	            case 3 -> System.out.println("Cersenbe");
	            case 4 -> System.out.println("Cume axsami");
	            case 5 -> System.out.println("Cume");
	            case 6 -> System.out.println("Senbe");
	            case 7 -> System.out.println("Bazar");
	            default -> System.out.println("Yanlis gun nomresi");
	        }

	        // Switch 2
	        int ay = sc.nextInt();
	        switch (ay) {
	            case 12, 1, 2 -> System.out.println("Qis");
	            case 3, 4, 5 -> System.out.println("Yaz");
	            case 6, 7, 8 -> System.out.println("Yay");
	            case 9, 10, 11 -> System.out.println("Payiz");
	            default -> System.out.println("Yanlis ay nomresi");
	        }

	        // Switch 3
	        int nomre = sc.nextInt();
	        switch (nomre) {
	            case 1 -> System.out.println("Bazar ertesi");
	            case 2 -> System.out.println("Cersenbe axsami");
	            case 3 -> System.out.println("Cersenbe");
	            case 4 -> System.out.println("Cume axsami");
	            case 5 -> System.out.println("Cume");
	            case 6 -> System.out.println("Senbe");
	            case 7 -> System.out.println("Bazar");
	            default -> System.out.println("Yanlis gun nomresi");
	        }

	        // Switch 4
	        int mehsul = sc.nextInt();
	        switch (mehsul) {
	            case 1 -> System.out.println("Alma - 1.5 AZN");
	            case 2 -> System.out.println("Portagal - 2.0 AZN");
	            case 3 -> System.out.println("Banan - 1.8 AZN");
	            case 4 -> System.out.println("Üzüm - 3.0 AZN");
	            default -> System.out.println("Yanlis mehsul secimi");
	        }
	    }
	}

}
