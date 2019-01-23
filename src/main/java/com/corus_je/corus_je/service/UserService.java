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


/*
    public String login(String username,String password){

            User user=userRepository.findByUsername(username);
        System.out.println("service에서 인코드된 pw: "+password);
            if(password.equals(user.getPassword()))
                return "Login Success";
            else return "Login fail";

    }
    public User getUser(String username){
        return userRepository.findByUsername(username);
    }

    public User findUserbyId(Long id){
        User stu=new User();
        try{
            stu= userRepository.findById(id).get();
        }catch (Exception e){

        }finally {
            return stu;
        }




    }

    public List<User> findAllUsers(){
        List<User> users =new LinkedList<>();
        try{
            users = userRepository.findAll();
        }catch (Exception e){

        }finally {
            return users;
        }

    }


    public User updateUserbyId(User user) {
        User stu=new User();
        try {
            stu= userRepository.save(user);
        } catch (Exception e) {

        } finally {
            return stu;
        }

    }


    public void removeUserbyId(Long id){
        try{
            userRepository.deleteById(id);
        }catch (Exception e){

        }finally {

        }
    }

    public User getUserName(String username){
        return userRepository.findByUsername(username);
    }*/

}