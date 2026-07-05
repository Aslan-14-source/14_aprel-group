package az.developia.ComputerShopping.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.ComputerShopping.RequestDto.ComputerRequestDto;
import az.developia.ComputerShopping.ResponseDto.ComputerResponseDto;
import az.developia.ComputerShopping.entity.Computer;
import az.developia.ComputerShopping.repository.ComputerRepo;

@Service
public class ComputerService {

	@Autowired
	private ComputerRepo computerRepo;

	@Autowired
	private ModelMapper modelMapper;

	public List<Computer> getComputers(String brand) {
		if (brand == null || brand.isEmpty()) {
			return computerRepo.findAll();
		}
		return computerRepo.findByBrandContaining(brand);
	}

	public Optional<Computer> getComputerById(Integer id) {
		return computerRepo.findById(id);
	}

	public void addComputer(ComputerRequestDto dto) {
		Computer computer = modelMapper.map(dto, Computer.class);
		computerRepo.save(computer);
	}

	public String updateComputer(Computer computer) {

		if (!computerRepo.existsById(computer.getId())) {
			return "Computer tapılmadı";
		}

		computerRepo.save(computer);
		return "Computer yeniləndi";
	}

	public void deleteComputer(Integer id) {
		computerRepo.deleteById(id);
	}

	public List<Computer> findByBrand(String brand) {
		return computerRepo.findByBrandContaining(brand);
	}

	public List<Computer> findPriceRange(Double min, Double max) {
		return computerRepo.findComputersByPriceRange(min, max);
	}

	public Long countAllComputers() {
		return computerRepo.count();
	}

	public ComputerResponseDto convertToResponseDto(Computer computer) {
		return modelMapper.map(computer, ComputerResponseDto.class);
	}

	public List<ComputerResponseDto> getAll() {
		return computerRepo.findAll().stream().map(this::convertToResponseDto).collect(Collectors.toList());
	}

	public ComputerResponseDto getById(Integer id) {
		return computerRepo.findById(id).map(this::convertToResponseDto).orElse(null);
	}

	public void add(ComputerRequestDto dto) {
		addComputer(dto);
	}

	public void update(ComputerRequestDto dto) {
		Computer computer = modelMapper.map(dto, Computer.class);
		computerRepo.save(computer);
	}

	public void delete(Integer id) {
		deleteComputer(id);
	}

	public List<Computer> findByPriceRange(Double min, Double max) {
		return findPriceRange(min, max);
	}

	public List<Computer> pagination(Integer begin, Integer length) {
		return computerRepo.pagination(begin, length);
	}

	public List<Computer> paginationSortByPrice(Integer begin, Integer length) {
		return computerRepo.paginationSortByPrice(begin, length);
	}
}