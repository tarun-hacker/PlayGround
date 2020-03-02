package com.tarun.invoizer.repositories;

import com.tarun.invoizer.models.enums.ERole;
import com.tarun.invoizer.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(ERole name);
}
