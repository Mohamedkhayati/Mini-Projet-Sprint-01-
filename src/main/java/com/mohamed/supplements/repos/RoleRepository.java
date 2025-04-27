package com.mohamed.supplements.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mohamed.supplements.entities.Role;
public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}