package Main;

import java.util.LinkedList;
import java.util.Queue;

public class Task1 {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		queue.add("A");
		queue.add("B");
		queue.add("C");
		queue.add("D");
		System.out.println("Queue: " + queue);
		System.out.println("En ust element: " + queue.peek());

		String silinen = queue.poll();
		System.out.println("Silinən element: " + silinen);

		System.out.println("Yenilənmiş Queue: " + queue);
	}
}
