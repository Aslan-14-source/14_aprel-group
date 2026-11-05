
package az.developia.computerservice.response;

import java.util.List;

import az.developia.computerservice.entity.Computer;

public class ComputerListResponse {

	private List<Computer> computers;

	public ComputerListResponse() {
	}

	public ComputerListResponse(List<Computer> computers) {
		this.computers = computers;
	}

	public List<Computer> getComputers() {
		return computers;
	}

	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}
}
