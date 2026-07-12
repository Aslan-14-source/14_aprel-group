package az.developia.spring_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.spring_project.CarRequestDto.CarRequestDto;
import az.developia.spring_project.CarResponseDto.CarResponseDto;
import az.developia.spring_project.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarService service;

	@PostMapping("/add")
	public void addCar(@RequestBody CarRequestDto dto) {
		service.addCar(dto);
	}

	@GetMapping("/all")
	public List<CarResponseDto> getAllCars() {
		return service.getAllCars();
	}
}