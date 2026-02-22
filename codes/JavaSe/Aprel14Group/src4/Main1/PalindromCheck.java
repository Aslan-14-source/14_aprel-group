package Main1;

import java.util.Scanner;
import java.util.Stack;

public class PalindromCheck {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Bir söz daxil edin: ");
		String word = sc.nextLine();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < word.length(); i++) {
			stack.push(word.charAt(i));
		}

		String reversed = "";

		while (!stack.isEmpty()) {
			reversed += stack.pop();
		}

		if (word.equals(reversed)) {
			System.out.println("Bu söz palindromdur ✅");
		} else {
			System.out.println("Bu söz palindrom deyil ❌");
		}
	}
}