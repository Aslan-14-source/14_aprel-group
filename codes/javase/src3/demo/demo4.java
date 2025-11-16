package demo;
import java.util.Scanner;

public class demo4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ===================== TASK 3 =====================
        System.out.println("\n--- TASK 3 ---");
        System.out.print("Birinci ededi daxil edin: ");
        int a = sc.nextInt();

        System.out.print("Ikinci ededi daxil edin: ");
        int b = sc.nextInt();

        System.out.println("Hasil: " + (a * b));



        // ===================== TASK 4 =====================
        System.out.println("\n--- TASK 4 ---");
        System.out.print("Radiusu daxil edin: ");
        double r = sc.nextDouble();

        double uzunluq = 2 * Math.PI * r;
        System.out.println("Cevrenin uzunlugu: " + uzunluq);



        // ===================== TASK 5 =====================
        System.out.println("\n--- TASK 5 ---");
        System.out.print("Eded daxil edin: ");
        int n = sc.nextInt();

        int cemReqem = 0;
        int temp = n;

        while (temp > 0) {
            cemReqem += temp % 10;
            temp /= 10;
        }
        System.out.println("Reqemlerin cemi: " + cemReqem);



        // ===================== TASK 6 =====================
        System.out.println("\n--- TASK 6 ---");
        System.out.print("Eded daxil edin: ");
        int sadeEded = sc.nextInt();

        boolean sade = true;

        if (sadeEded <= 1) {
            sade = false;
        } else {
            for (int i = 2; i <= sadeEded / 2; i++) {
                if (sadeEded % i == 0) {
                    sade = false;
                    break;
                }
            }
        }

        if (sade)
            System.out.println("Eded sadedir.");
        else
            System.out.println("Eded sade deyil.");



        // ===================== TASK 7 =====================
        System.out.println("\n--- TASK 7 ---");
        int cem1_100 = 0;

        for (int i = 1; i <= 100; i++) {
            cem1_100 += i;
        }

        System.out.println("1-100 araligindaki ededlerin cemi: " + cem1_100);



        // ===================== TASK 8 =====================
        System.out.println("\n--- TASK 8 ---");
        System.out.println("1-100 araliginda 7-ye qaliqsiz bolunen ededler:");

        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();



        // ===================== TASK 9 =====================
        System.out.println("\n--- TASK 9 ---");
        System.out.print("Eded daxil edin: ");
        int cutYoxla = sc.nextInt();

        if (cutYoxla % 2 == 0)
            System.out.println("Eded cutdur.");
        else
            System.out.println("Eded tekdir.");



        // ===================== TASK 10 =====================
        System.out.println("\n--- TASK 10 ---");
        System.out.println("1–200 araliginda hem 3-e hem 7-ye bolunen ededler:");

        for (int i = 1; i <= 200; i++) {
            if (i % 3 == 0 && i % 7 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println("\n\nBütün tapşırıqlar bitdi!");
    }
}