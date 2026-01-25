package Ders;

class Player {

	String name;
	int score;

	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof Player))
			return false;

		Player other = (Player) obj;
		return this.name.equals(other.name) && this.score == other.score;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + score;
	}

	@Override
	public String toString() {
		return "Player{name='" + name + "', score=" + score + "}";
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Player obyekti silinir: " + name);
	}
}
