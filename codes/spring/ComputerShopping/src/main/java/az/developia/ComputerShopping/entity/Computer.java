package az.developia.ComputerShopping.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "computers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "user")
public class Computer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String brand;

	private String model;

	private Double price;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "specification_id")
	private Specification specification;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
}
