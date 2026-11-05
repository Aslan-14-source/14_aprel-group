
package az.developia.computerservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.computerservice.entity.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Long> {

	List<Computer> findByUserId(Long userId);
}
