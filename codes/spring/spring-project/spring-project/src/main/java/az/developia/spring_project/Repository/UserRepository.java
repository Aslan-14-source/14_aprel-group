package az.developia.spring_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.spring_project.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByUsername(String username);

}