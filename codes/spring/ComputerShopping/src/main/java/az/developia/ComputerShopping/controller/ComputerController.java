package az.developia.ComputerShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import az.developia.ComputerShopping.RequestDto.ComputerRequestDto;
import az.developia.ComputerShopping.ResponseDto.ComputerResponseDto;
import az.developia.ComputerShopping.entity.Computer;
import az.developia.ComputerShopping.service.ComputerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/computers")
public class ComputerController {

	@Autowired
	private ComputerService service;

	@GetMapping
	public List<ComputerResponseDto> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ComputerResponseDto getById(@PathVariable Integer id) {

		ComputerResponseDto dto = service.getById(id);

		if (dto == null) {
			throw new RuntimeException("Computer tapılmadı");
		}

		return dto;
	}

	@PostMapping
	public String add(@RequestBody ComputerRequestDto dto) {

		service.add(dto);

		return "Computer elave edildi";
	}

	@PutMapping
	public String update(@RequestBody ComputerRequestDto dto) {

		service.update(dto);

		return "Computer yeniləndi";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {

		service.delete(id);

		return "Computer silindi";
	}

	@GetMapping("/search")
	public List<ComputerResponseDto> searchByBrand(@RequestParam String brand) {

		return service.findByBrand(brand).stream().map(computer -> service.convertToResponseDto(computer)).toList();
	}

	@GetMapping("/price")
	public List<ComputerResponseDto> searchByPrice(@RequestParam(name = "minprice") Double min,
			@RequestParam(name = "maxprice") Double max) {

		return service.findByPriceRange(min, max).stream().map(computer -> service.convertToResponseDto(computer))
				.toList();
	}

	@GetMapping("/count")
	public Long countAllComputers() {
		return service.countAllComputers();
	}

	@GetMapping("/pagination/begin/{begin}/length/{length}")
	public List<Computer> pagination(@PathVariable Integer begin, @PathVariable Integer length) {

		return service.pagination(begin, length);
	}

	@GetMapping("/pagination/sort/price/begin/{begin}/length/{length}")
	public List<Computer> paginationSortByPrice(@PathVariable Integer begin, @PathVariable Integer length) {

		return service.paginationSortByPrice(begin, length);
	}
}