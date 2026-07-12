package az.developia.spring_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.spring_project.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}