package az.developia.homework.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Home {

	private int id;
	private String color;
	private String address;
	private String name;

	public Home() {

		this.id = 1;
		this.color = "White";
		this.address = "Baku";
		this.name = "Aslan";

		System.out.println("Constructor işə düşdü");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void init() {
		System.out.println("init");
	}

	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public String toString() {
		return "Home{" + "id=" + id + ", color='" + color + '\'' + ", address='" + address + '\'' + ", name='" + name
				+ '\'' + '}';
	}
}