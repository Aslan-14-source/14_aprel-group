package Main;

import java.util.Stack;

public class Task3 {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("a");
		stack.push("d");
		stack.push("c");
		stack.push("b");

		System.out.println("Stack: " + stack);
		System.out.println("en son elave edilen elemennt: " + stack.peek());

	}
}
