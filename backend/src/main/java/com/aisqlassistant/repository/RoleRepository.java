package com.aisqlassistant.repository;

import com.aisqlassistant.entity.Role;
import com.aisqlassistant.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(UserRole roleName);

}