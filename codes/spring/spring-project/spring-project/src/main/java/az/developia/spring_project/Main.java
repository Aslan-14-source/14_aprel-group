package az.developia.spring_project;

import az.developia.spring_project.entity.Home;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringProjectApplication.class);

		Home home1 = context.getBean(Home.class);
		Home home2 = context.getBean(Home.class);

		System.out.println(home1);
		System.out.println(home2);

		System.out.println(home1 == home2);
	}
}