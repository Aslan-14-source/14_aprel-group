package az.developia.ComputerShopping.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "specifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "computer")
public class Specification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String cpu;
	private Integer ram;
	private Integer storage;

	@OneToOne(mappedBy = "specification")
	private Computer computer;
}