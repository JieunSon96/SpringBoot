
package com.corus_je.corus_je.controller;

import com.corus_je.corus_je.entity.User;
import com.corus_je.corus_je.exception.ResourceNotFoundException;
import com.corus_je.corus_je.repository.RoleRepository;
import com.corus_je.corus_je.security.JwtTokenProvider;
import com.corus_je.corus_je.service.UserService;
import com.corus_je.corus_je.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/user")

public class UserController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserService userService;


    @GetMapping("/users")
    public List<User> findAllUsers() {
        List<User> users = userService.getAllUser();
        return users;
    }


    @GetMapping("/retrieveUser")
    public ResponseEntity<User> retrieveByUserName(HttpServletRequest request) {
        User user = userService.findByUserName(request.getUserPrincipal().getName())
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", request.getUserPrincipal().getName()));
        return new ResponseEntity<User>(user, HttpStatus.OK);


    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUserbyId(HttpServletRequest request) {
        User user = userService.findByUserName(request.getUserPrincipal().getName())
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", request.getUserPrincipal().getName()));
        userService.deleteUserbyId(user);
        return new ResponseEntity(new ApiResponse(true, user.getUsername()+" User account is removed!"),
                HttpStatus.OK);
    }


 /*@PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUserbyId(@PathVariable(value = "userId") Long userId, @Valid @RequestBody User userDetails) {
        User stu = userService.findUserbyId(userId);
        if (stu.getId().equals(userId)) {
            final User updatedUser = userService.updateUserbyId(userDetails);
            return ResponseEntity.ok(updatedUser);
        } else {
            return new ResponseEntity<User>(stu, HttpStatus.NOT_FOUND);
        }


    }*/
}
