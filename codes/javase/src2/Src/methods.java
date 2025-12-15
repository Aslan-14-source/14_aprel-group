package Src;

public class methods {
	public class Example {
	    public static void main(String[] args) {

	        String s = "Hello World";

	        System.out.println(s.length());
	        System.out.println(s.toUpperCase());
	        System.out.println(s.toLowerCase());
	        System.out.println(s.charAt(0));
	        System.out.println(s.indexOf("o"));
	        System.out.println(s.lastIndexOf("o"));
	        System.out.println(s.contains("World"));
	        System.out.println(s.startsWith("Hel"));
	        System.out.println(s.endsWith("ld"));
	        System.out.println(s.equals("Hello World"));
	        System.out.println(s.equalsIgnoreCase("hello world"));
	        System.out.println(s.substring(6));
	        System.out.println(s.substring(0, 5));
	        System.out.println(s.concat("!!!"));
	        System.out.println(s.replace("World", "Java"));
	        System.out.println(s.trim());
	        System.out.println(s.repeat(2));
	        System.out.println(s.isEmpty());
	        System.out.println(s.compareTo("Hello World"));
	        System.out.println(s.compareToIgnoreCase("hello world"));
	        System.out.println(s.toCharArray().length);
	        System.out.println(String.valueOf(123));
	        System.out.println(String.join("-", "A", "B", "C"));
	    }
	}
}
