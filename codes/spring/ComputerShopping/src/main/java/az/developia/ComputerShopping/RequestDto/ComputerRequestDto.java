package az.developia.ComputerShopping.RequestDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComputerRequestDto {

	private Integer id;
	private String brand;
	private String model;
	private Double price;
}