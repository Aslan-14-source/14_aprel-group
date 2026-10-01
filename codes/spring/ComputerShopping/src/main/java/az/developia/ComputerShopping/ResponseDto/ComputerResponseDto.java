package az.developia.ComputerShopping.ResponseDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComputerResponseDto {

	private Integer id;

	private String brand;

	private String model;

	private Double price;

	private Integer userId;

	private Integer specificationId;

	private Integer categoryId;
}
