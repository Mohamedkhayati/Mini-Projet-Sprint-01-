package com.mohamed.supplements.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mohamed.supplements.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}
