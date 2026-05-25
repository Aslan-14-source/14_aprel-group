package az.developia.spring_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import az.developia.spring_project.config.AppService;

@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(SpringProjectApplication.class, args);

		AppService bean = run.getBean(AppService.class);

		bean.showAppInfo();
	}
}