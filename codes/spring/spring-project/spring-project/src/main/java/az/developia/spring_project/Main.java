package az.developia.spring_project;

import az.developia.spring_project.entity.Home;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import az.developia.spring_project.entity.User;

public class Main {

	public static void main(String[] args) {

		User user = new User("Aslan", 18);

		System.out.println(user);

	}
}