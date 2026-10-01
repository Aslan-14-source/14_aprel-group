package az.developia.ComputerShopping.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import az.developia.ComputerShopping.entity.Computer;
import az.developia.ComputerShopping.entity.User;
import az.developia.ComputerShopping.repository.ComputerRepo;
import az.developia.ComputerShopping.repository.UserRepository;
import az.developia.ComputerShopping.RequestDto.ComputerRequestDto;
import az.developia.ComputerShopping.ResponseDto.ComputerResponseDto;

@ExtendWith(MockitoExtension.class)
class ComputerServiceTest {

	@Mock
	private ComputerRepo computerRepo;

	@Mock
	private UserRepository userRepository;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	private ComputerService computerService;

	@BeforeEach
	void setUp() {
		SecurityContextHolder.clearContext();
	}

	@Test
	void testGetAllSuccess() {
		Computer computer = new Computer();
		ComputerResponseDto dto = new ComputerResponseDto();

		when(computerRepo.findAll()).thenReturn(List.of(computer));
		when(modelMapper.map(computer, ComputerResponseDto.class)).thenReturn(dto);

		List<ComputerResponseDto> result = computerService.getAll();

		assertNotNull(result);
		assertEquals(1, result.size());
		assertSame(dto, result.get(0));
		verify(computerRepo).findAll();
	}

	@Test
	void testGetAllEmpty() {
		when(computerRepo.findAll()).thenReturn(List.of());

		List<ComputerResponseDto> result = computerService.getAll();

		assertNotNull(result);
		assertTrue(result.isEmpty());
		verify(computerRepo).findAll();
	}

	@Test
	void testGetByIdSuccess() {
		Computer computer = new Computer();
		ComputerResponseDto dto = new ComputerResponseDto();

		when(computerRepo.findById(1)).thenReturn(Optional.of(computer));
		when(modelMapper.map(computer, ComputerResponseDto.class)).thenReturn(dto);

		ComputerResponseDto result = computerService.getById(1);

		assertNotNull(result);
		assertSame(dto, result);
		verify(computerRepo).findById(1);
	}

	@Test
	void testGetByIdNotFound() {
		when(computerRepo.findById(99)).thenReturn(Optional.empty());

		ComputerResponseDto result = computerService.getById(99);

		assertNull(result);
		verify(computerRepo).findById(99);
		verifyNoInteractions(modelMapper);
	}

	@Test
	void testAddSuccess() {
		ComputerRequestDto request = new ComputerRequestDto();
		Computer computer = new Computer();
		User user = new User();

		SecurityContextHolder.getContext()
				.setAuthentication(new UsernamePasswordAuthenticationToken("testuser", "password"));

		when(userRepository.findByUsername("testuser")).thenReturn(user);
		when(modelMapper.map(request, Computer.class)).thenReturn(computer);

		computerService.add(request);

		assertSame(user, computer.getUser());
		verify(userRepository).findByUsername("testuser");
		verify(modelMapper).map(request, Computer.class);
		verify(computerRepo).save(computer);
	}

	@Test
	void testAddRepositoryException() {
		ComputerRequestDto request = new ComputerRequestDto();
		Computer computer = new Computer();
		User user = new User();

		SecurityContextHolder.getContext()
				.setAuthentication(new UsernamePasswordAuthenticationToken("testuser", "password"));

		when(userRepository.findByUsername("testuser")).thenReturn(user);
		when(modelMapper.map(request, Computer.class)).thenReturn(computer);
		when(computerRepo.save(computer)).thenThrow(new RuntimeException("Database error"));

		assertThrows(RuntimeException.class, () -> computerService.add(request));

		verify(computerRepo).save(computer);
	}

	@Test
	void testUpdateSuccess() {
		Computer computer = new Computer();
		ComputerRequestDto dto = new ComputerRequestDto();

		dto.setBrand("ASUS");
		dto.setModel("TUF F15");
		dto.setPrice(1500.0);

		when(computerRepo.findById(1)).thenReturn(Optional.of(computer));

		computerService.update(1, dto);

		assertEquals("ASUS", computer.getBrand());
		assertEquals("TUF F15", computer.getModel());
		assertEquals(1500.0, computer.getPrice());

		verify(computerRepo).findById(1);
		verify(computerRepo).save(computer);
	}

	@Test
	void testUpdateNotFound() {
		ComputerRequestDto dto = new ComputerRequestDto();

		when(computerRepo.findById(99)).thenReturn(Optional.empty());

		computerService.update(99, dto);

		verify(computerRepo).findById(99);
		verify(computerRepo, never()).save(any());
	}

	@Test
	void testDeleteSuccess() {
		doNothing().when(computerRepo).deleteById(1);

		assertDoesNotThrow(() -> computerService.delete(1));

		verify(computerRepo).deleteById(1);
	}

	@Test
	void testDeleteException() {
		doThrow(new RuntimeException("Delete error")).when(computerRepo).deleteById(1);

		assertThrows(RuntimeException.class, () -> computerService.delete(1));

		verify(computerRepo).deleteById(1);
	}

	@Test
	void testFindByBrandSuccess() {
		Computer computer = new Computer();

		when(computerRepo.findByBrandContaining("ASUS")).thenReturn(List.of(computer));

		List<Computer> result = computerService.findByBrand("ASUS");

		assertNotNull(result);
		assertEquals(1, result.size());
		assertSame(computer, result.get(0));
		verify(computerRepo).findByBrandContaining("ASUS");
	}

	@Test
	void testFindByBrandEmpty() {
		when(computerRepo.findByBrandContaining("Unknown")).thenReturn(List.of());

		List<Computer> result = computerService.findByBrand("Unknown");

		assertNotNull(result);
		assertTrue(result.isEmpty());
		verify(computerRepo).findByBrandContaining("Unknown");
	}

	@Test
	void testFindByPriceRangeSuccess() {
		Computer computer = new Computer();

		when(computerRepo.findComputersByPriceRange(500.0, 2000.0)).thenReturn(List.of(computer));

		List<Computer> result = computerService.findByPriceRange(500.0, 2000.0);

		assertNotNull(result);
		assertEquals(1, result.size());
		assertSame(computer, result.get(0));
		verify(computerRepo).findComputersByPriceRange(500.0, 2000.0);
	}

	@Test
	void testFindByPriceRangeEmpty() {
		when(computerRepo.findComputersByPriceRange(100.0, 200.0)).thenReturn(List.of());

		List<Computer> result = computerService.findByPriceRange(100.0, 200.0);

		assertNotNull(result);
		assertTrue(result.isEmpty());
		verify(computerRepo).findComputersByPriceRange(100.0, 200.0);
	}

	@Test
	void testGetPaginationSuccess() {
		Computer computer = new Computer();
		ComputerResponseDto dto = new ComputerResponseDto();

		Page<Computer> computerPage = new PageImpl<>(List.of(computer));

		when(computerRepo.findAll(any(org.springframework.data.domain.Pageable.class))).thenReturn(computerPage);
		when(modelMapper.map(computer, ComputerResponseDto.class)).thenReturn(dto);

		Page<ComputerResponseDto> result = computerService.getPagination(0, 5);

		assertNotNull(result);
		assertEquals(1, result.getTotalElements());
		assertSame(dto, result.getContent().get(0));
		verify(computerRepo).findAll(any(org.springframework.data.domain.Pageable.class));
	}

	@Test
	void testGetPaginationEmpty() {
		Page<Computer> emptyPage = new PageImpl<>(List.of());

		when(computerRepo.findAll(any(org.springframework.data.domain.Pageable.class))).thenReturn(emptyPage);

		Page<ComputerResponseDto> result = computerService.getPagination(0, 5);

		assertNotNull(result);
		assertTrue(result.getContent().isEmpty());
		assertEquals(0, result.getTotalElements());
		verify(computerRepo).findAll(any(org.springframework.data.domain.Pageable.class));
	}
}