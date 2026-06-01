package az.developia.spring_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.spring_project.entity.Car;

@RestController
public class CarController {

	@GetMapping("/cars")
	public List<Car> getCars() {

		List<Car> cars = new ArrayList<>();

		cars.add(new Car(1L, "BMW", "E92 M3", 2010));
		cars.add(new Car(2L, "Mercedes", "CLS63 AMG", 2014));
		cars.add(new Car(3L, "Audi", "RS6", 2019));

		return cars;
	}
}