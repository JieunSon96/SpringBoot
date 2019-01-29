package com.corus_je.corus_je.service;

import com.corus_je.corus_je.entity.User;
import com.corus_je.corus_je.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean existsByUsername(String username) {
        boolean result = false;
        try {
            result = userRepository.existsByUsername(username);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return result;
        }
    }

    public boolean existsByEmail(String email) {
        boolean result = false;
        try {
            result = userRepository.existsByEmail(email);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return result;
        }
    }

    public User createUser(User user) {
        User createUser = new User();
        try {
            createUser = userRepository.save(user);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return createUser;
        }

    }


    public List<User> getAllUser() {
        List<User> users = new LinkedList<>();
        try {
            users = userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return users;
        }
    }
public Optional<User> findById(Long userId){
       return userRepository.findById(userId);
}

    public Optional<User> findByUserName(String userName) {
        Optional<User> user = userRepository.findByUsername(userName);
        return user;
    }

    public void deleteUserbyId(User user) {
        try {
            userRepository.delete(user);
        } catch (Exception e) {

        } finally {

        }
    }


}