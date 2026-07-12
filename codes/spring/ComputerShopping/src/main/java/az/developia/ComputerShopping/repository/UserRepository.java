package az.developia.ComputerShopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import az.developia.ComputerShopping.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	@Query(value = "SELECT COUNT(*) FROM users", nativeQuery = true)
	long countAllUsers();
}