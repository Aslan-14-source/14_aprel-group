package az.developia.spring_project.CarRequestDto;

import lombok.Data;

@Data
public class CarRequestDto {
	
	private Long Id;
	private String marka;
	private String model;
	private Integer year;

}
