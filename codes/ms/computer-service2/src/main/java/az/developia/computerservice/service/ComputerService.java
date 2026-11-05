
package az.developia.computerservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import az.developia.computerservice.entity.Computer;
import az.developia.computerservice.repository.ComputerRepository;
import az.developia.computerservice.response.UserWithComputersResponse;

@Service
public class ComputerService {

    private final ComputerRepository computerRepository;
    private final RestTemplate restTemplate;

    public ComputerService(
            ComputerRepository computerRepository,
            RestTemplate restTemplate) {
        this.computerRepository = computerRepository;
        this.restTemplate = restTemplate;
    }

    public List<Computer> getComputersByUserId(Long userId) {
        return computerRepository.findByUserId(userId);
    }

    public UserWithComputersResponse getUserWithComputers(Long userId) {
        String url = "http://user-service/users/" + userId + "/computers";

        return restTemplate.getForObject(
                url,
                UserWithComputersResponse.class
        );
    }
}
