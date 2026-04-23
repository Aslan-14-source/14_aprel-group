package Devsys;

interface RunStrategy {
	void run();
}

class FastRun implements RunStrategy {
	public void run() {
		System.out.println("Running fast!");
	}
}

class SlowRun implements RunStrategy {
	public void run() {
		System.out.println("Running slow...");
	}
}

class Character {
	private RunStrategy runStrategy;

	public void setRunStrategy(RunStrategy runStrategy) {
		this.runStrategy = runStrategy;
	}

	public void performRun() {
		runStrategy.run();
	}
}

public class StrategyTest {
	public static void main(String[] args) {
		Character hero = new Character();

		hero.setRunStrategy(new FastRun());
		hero.performRun();

		hero.setRunStrategy(new SlowRun());
		hero.performRun();
	}
}