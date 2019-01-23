package com.corus_je.corus_je.repository;

import com.corus_je.corus_je.entity.Role;
import com.corus_je.corus_je.entity.RoleNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleNames roleName);
}