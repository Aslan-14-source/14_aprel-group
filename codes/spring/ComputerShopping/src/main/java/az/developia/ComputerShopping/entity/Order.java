package az.developia.ComputerShopping.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "user")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private LocalDate orderDate;

	private Double totalPrice;

	private String status;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}