package accessModifiers;

public class Task {
	String word = "salam";
	String reversed = "meow"
;
	for (int i = word.length() - 1; i >= 0; i--) {
	    reversed = reversed + word.charAt(i);
	}

	System.out.println(reversed);

}}
	