package az.developia.ComputerShopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import az.developia.ComputerShopping.entity.Computer;

public interface ComputerRepo extends JpaRepository<Computer, Integer> {

	List<Computer> findByBrandContaining(String brand);

	@Query(value = "SELECT * " + "FROM computers " + "WHERE price BETWEEN :a AND :b", nativeQuery = true)
	List<Computer> findComputersByPriceRange(@Param("a") Double a, @Param("b") Double b);

	@Query(value = "SELECT * FROM computers LIMIT ?1, ?2", nativeQuery = true)
	List<Computer> pagination(Integer begin, Integer length);

	@Query(value = "SELECT * FROM computers ORDER BY price ASC LIMIT ?1, ?2", nativeQuery = true)
	List<Computer> paginationSortByPrice(Integer begin, Integer length);
}