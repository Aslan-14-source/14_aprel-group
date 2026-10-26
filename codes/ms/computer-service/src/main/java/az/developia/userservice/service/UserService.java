
package az.developia.userservice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import az.developia.userservice.entity.User;
import az.developia.userservice.repository.UserRepository;
import az.developia.userservice.response.UserWithComputersResponse;
import az.developia.userservice.response.UserWithComputersResponse.ComputerDto;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final RestTemplate restTemplate;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.restTemplate = new RestTemplate();
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public UserWithComputersResponse getUserWithComputers(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("Istifadeci tapilmadi: " + userId));

		ComputerListDto result = restTemplate.getForObject("http://localhost:8081/computers/user/" + userId,
				ComputerListDto.class);

		List<ComputerDto> computerList = result == null || result.getComputers() == null ? List.of()
				: result.getComputers();

		return new UserWithComputersResponse(user, computerList);
	}

	public static class ComputerListDto {

		private List<ComputerDto> computers;

		public List<ComputerDto> getComputers() {
			return computers;
		}

		public void setComputers(List<ComputerDto> computers) {
			this.computers = computers;
		}
	}
}
