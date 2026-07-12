package az.developia.ComputerShopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import az.developia.ComputerShopping.entity.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {

	List<Computer> findByBrandContaining(String brand);

	@Query(value = "SELECT * FROM computers WHERE price BETWEEN :a AND :b", nativeQuery = true)
	List<Computer> findComputersByPriceRange(@Param("a") Double a, @Param("b") Double b);

	@Query(value = "SELECT COUNT(*) FROM computers", nativeQuery = true)
	Long countAllComputers();
}