package az.developia.spring_project;

import az.developia.spring_project.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringProjectApplication.class, args);

		Person person = context.getBean(Person.class);

		System.out.println("ID: " + person.getId());
		System.out.println("Name: " + person.getName());
		System.out.println("Age: " + person.getAge());
		System.out.println("Salary: " + person.getSalary());

		String[] beans = context.getBeanDefinitionNames();

		System.out.println("\n--- Bütün Bean-lər ---");
		for (String bean : beans) {
			System.out.println(bean);
		}
	}
}