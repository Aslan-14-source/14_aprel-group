package demo;

public class Methods {
	    void printName(int count, String name) {
	        for (int i = 0; i < count; i++) {
	            System.out.println(name);
	        }
	    }

	    public static void main(String[] args) {


	        Methods obj = new Methods();


	        obj.printName(3, "Aslan");
	        obj.printName(2, "Java");
	        obj.printName(5, "Developia");
	    }
	}


