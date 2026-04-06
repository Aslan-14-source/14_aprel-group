package Devsys;

public class thread1 extends Thread {

	@Override
	public void run() {
		for (int num = 1; num < 6; num++) {
			System.out.println("Number: " + num);
			try {
				Thread.sleep(180);
			} catch (InterruptedException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}
	}
}