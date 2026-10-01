package az.developia.ComputerShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import az.developia.ComputerShopping.RequestDto.ComputerRequestDto;
import az.developia.ComputerShopping.ResponseDto.ComputerResponseDto;
import az.developia.ComputerShopping.service.ComputerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/computers")
public class ComputerController {

	@Autowired
	private ComputerService service;

	@GetMapping
	@PreAuthorize("hasAuthority('COMPUTER_READ')")
	public List<ComputerResponseDto> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('COMPUTER_READ')")
	public ComputerResponseDto getById(@PathVariable Integer id) {
		return service.getById(id);
	}

	@PostMapping
	@PreAuthorize("hasAuthority('COMPUTER_CREATE')")
	public String add(@RequestBody ComputerRequestDto dto) {
		service.add(dto);
		return "Computer əlavə edildi";
	}

	@PutMapping
	@PreAuthorize("hasAuthority('COMPUTER_UPDATE')")
	public String update(@RequestBody ComputerRequestDto dto) {
		service.update(dto);
		return "Computer yeniləndi";
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('COMPUTER_DELETE')")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "Computer silindi";
	}

	@GetMapping("/page")
	@PreAuthorize("hasAuthority('COMPUTER_READ')")
	public Page<ComputerResponseDto> pagination(@RequestParam int page, @RequestParam int size) {

		return service.getPagination(page, size);
	}
}