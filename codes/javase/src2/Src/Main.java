package Src;

public class Main {
    public static void main(String[] args) {

        String name = "Məhərrəm";
        System.out.println(name);

        String message = "Java dilini öyrənmək maraqlı və faydalıdır";
        System.out.println(message);

        System.out.println(message.length());
        System.out.println(message.charAt(6));
        System.out.println(message.indexOf('n'));
        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());
        System.out.println(message.contains("Java"));
        System.out.println(message.endsWith("dır"));
        System.out.println(message.startsWith("Java"));

        name = " Ayxan ";
        System.out.println(name.trim());

        name = "Kamil";
        System.out.println(name.substring(0, 4));

        name = "Hüseyn Mehdizade";
        String[] parts = name.split(" ");

        for (String p : parts) {
            System.out.println(p);
        }
    }
}
