package az.developia.ComputerShopping.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "orders", "computers" })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName;

	private String lastName;

	@Column(unique = true, nullable = false)
	private String username;

	private String password;

	private String email;

	private String role;

	private String authority;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Order> orders;

	@OneToMany(mappedBy = "user")
	private List<Computer> computers;
}
