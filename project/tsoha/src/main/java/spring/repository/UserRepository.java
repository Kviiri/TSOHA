package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
