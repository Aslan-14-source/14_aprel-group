package az.developia.ComputerShopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.ComputerShopping.entity.Computer;
import az.developia.ComputerShopping.repository.ComputerRepo;

@Service
public class ComputerService {

	@Autowired
	private ComputerRepo repo;

	public List<Computer> getComputers(String brand) {
		if (brand == null || brand.isEmpty()) {
			return repo.findAll();
		}

		return repo.findByBrandContaining(brand);
	}

	public Optional<Computer> getComputerById(Integer id) {
		return repo.findById(id);
	}

	public void addComputer(Computer computer) {
		repo.save(computer);
	}

	public String updateComputer(Computer computer) {
		repo.save(computer);
		return "Computer yeniləndi";
	}

	public void deleteComputer(Integer id) {
		repo.deleteById(id);
	}

	public List<Computer> findByBrand(String brand) {
		return repo.findByBrandContaining(brand);
	}

	public List<Computer> findPriceRange(Double a, Double b) {
		return repo.findComputersByPriceRange(a, b);
	}
}