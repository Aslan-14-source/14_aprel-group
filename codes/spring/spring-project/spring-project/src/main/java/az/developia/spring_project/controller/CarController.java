package az.developia.spring_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.spring_project.entity.Car;
import az.developia.spring_project.service.CarService;

@RequestMapping(path = "/cars")
@RestController
public class CarController {

	@Autowired
	private CarService service;

	@PostMapping("/add")
	public void addCar(@RequestBody Car car) {
		service.addCar(car);
	}
}