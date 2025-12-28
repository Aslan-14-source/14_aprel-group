package demo;

public class MethodsHome {

	    void printNumbers(int begin, int end) {
	        for (int i = begin; i <= end; i++) {
	            System.out.print(i + " ");
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {

	        MethodsHome obj = new MethodsHome();
	        
	        obj.printNumbers(1, 5);
	        obj.printNumbers(10, 15);
	        obj.printNumbers(3, 9);
	    }
	}

