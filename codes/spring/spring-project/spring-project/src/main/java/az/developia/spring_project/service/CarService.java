package az.developia.spring_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import az.developia.spring_project.entity.Car;
import az.developia.spring_project.Repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repo;

	public void addCar(Car car) {
		repo.save(car);
	}
}