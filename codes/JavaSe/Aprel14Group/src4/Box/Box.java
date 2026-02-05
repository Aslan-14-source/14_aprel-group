package Box;

public class Box<T> {

	private T value;

	public void set(T value) {
		this.value = value;
	}

	public T get() {
		return value;
	}

	public <E> void printAny(E data) {
		System.out.println(data);
	}
}
