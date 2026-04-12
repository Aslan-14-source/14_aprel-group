package devsys;

public class thread2 extends Thread {

	@Override
	public void run() {
		for (char letter = 'A'; letter < 'F'; letter++) {
			System.out.println("Letter: " + letter);
			try {
				Thread.sleep(220);
			} catch (InterruptedException ex) {
				System.out.println("Problem: " + ex.getMessage());
			}
		}
	}
}