package az.developia.ComputerShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import az.developia.ComputerShopping.entity.Computer;
import az.developia.ComputerShopping.service.ComputerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/computers")
public class ComputerController {

	@Autowired
	private ComputerService service;

	@GetMapping
	public List<Computer> getAll() {
		return service.getComputers(null);
	}

	@GetMapping("/{id}")
	public Computer getById(@PathVariable Integer id) {
		return service.getComputerById(id).orElseThrow(() -> new RuntimeException("Computer tapılmadı"));
	}

	@PostMapping
	public String add(@RequestBody Computer computer) {
		service.addComputer(computer);
		return "Computer elave edildi";
	}

	@PutMapping
	public String update(@RequestBody Computer computer) {
		return service.updateComputer(computer);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		service.deleteComputer(id);
		return "Computer silindi";
	}

	@GetMapping("/search")
	public List<Computer> searchByBrand(@RequestParam String brand) {
		return service.findByBrand(brand);
	}

	@GetMapping("/price")
	public List<Computer> searchByPrice(@RequestParam(name = "minprize") Double a,
			@RequestParam(name = "maxprize") Double b) {

		return service.findPriceRange(a, b);
	}

	@GetMapping("/count")
	public Long countAllComputers() {
		return service.countAllComputers();
	}
}