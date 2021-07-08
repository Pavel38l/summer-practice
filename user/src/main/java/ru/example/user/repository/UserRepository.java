package ru.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.user.entity.User;

/**
 * @author Burdyug Pavel
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
