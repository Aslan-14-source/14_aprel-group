package az.developia.spring_project.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.spring_project.Repository.CarRepository;
import az.developia.spring_project.entity.Car;
import az.developia.spring_project.CarRequestDto.CarRequestDto;
import az.developia.spring_project.CarResponseDto.CarResponseDto;

@Service
public class CarService {

	@Autowired
	private CarRepository repo;

	@Autowired
	private ModelMapper modelMapper;

	public void addCar(CarRequestDto dto) {

		Car car = modelMapper.map(dto, Car.class);

		repo.save(car);
	}

	public List<CarResponseDto> getAllCars() {

		List<Car> cars = repo.findAll();
		List<CarResponseDto> response = new ArrayList<>();

		for (Car car : cars) {

			CarResponseDto dto = modelMapper.map(car, CarResponseDto.class);

			response.add(dto);
		}

		return response;
	}
}