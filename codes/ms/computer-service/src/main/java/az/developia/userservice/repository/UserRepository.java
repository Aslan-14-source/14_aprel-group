
package az.developia.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
