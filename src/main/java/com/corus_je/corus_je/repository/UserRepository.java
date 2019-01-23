package com.corus_je.corus_je.repository;

import com.corus_je.corus_je.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /*User findByUsername(String username);

    Optional<User> findByEmail(String email);


    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);*/

    Optional<User> findByUsernameOrEmail(String username, String email);


    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
