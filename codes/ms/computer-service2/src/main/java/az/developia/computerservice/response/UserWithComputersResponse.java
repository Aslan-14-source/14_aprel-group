package az.developia.computerservice.response;

import java.util.List;

import az.developia.computerservice.entity.Computer;

public class UserWithComputersResponse {

	private Long userId;
	private String username;
	private List<Computer> computers;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Computer> getComputers() {
		return computers;
	}

	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}
}