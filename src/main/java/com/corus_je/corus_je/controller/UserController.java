
package com.corus_je.corus_je.controller;

import com.corus_je.corus_je.entity.Role;
import com.corus_je.corus_je.entity.User;
import com.corus_je.corus_je.pojo.UserRegistration;
import com.corus_je.corus_je.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/user")
//로그인, 회원가입, 로그아웃, 연구생성, 수정, 읽기, 삭제
public class UserController {


    @Autowired
    private UserService userService;

/*@RequestMapping("/")
    public String index() {
        return "index.html";
    }*/



    //회원가입
    /*@PostMapping("/register")
    public String createUsers(@Valid @RequestBody UserRegistration userRegistration) {
        System.out.println(userRegistration.getUsername() + " / " + userRegistration.getPassword() + " / ");

        //
        if (!userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation()))
            return "Error the two passwords do not match";
        else if (userService.getUserName(userRegistration.getUsername()) != null)
            return "Error this username already exists";

 userService.createUser(new User(userRegistration.getUsername(), userRegistration.getPassword(), Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));

        return "user Created";


    }*/


    //로그인
    /*@PostMapping("/login")
    public String login(String username,String password){
        System.out.println("username : "+ username +"  /pw: "+password);
        String loginResult=userService.login(username,password);
        System.out.println("로그인 결과: "+loginResult);
        if(loginResult.equals("Login Success"))
        return "board";
        else return "index";
    }*/


    /*@GetMapping("/users")
    public List<User> findAllUsers() {

        List<User> students = studentService.findAllStudents();

        return userService.findAllUsers();
    }*/

    //마이페이지
    /*@GetMapping("/users/{userId}")
    @CrossOrigin
    public ResponseEntity<User> findUserbyId(@PathVariable("userId") Long userId) {
        User stu = new User();
        User user = userService.findUserbyId(userId);
        if (user.getId().equals(userId)) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
        }

    }*/

    //로그아웃

/* @GetMapping("logout")
    public void logout(@RequestParam(value = "access_token")String accessToken){
        tokenStore.removeAccessToken(tokenStore.readAccessToken(accessToken));
    }*/



    //그 아이디가 실제 존재하는지 체크 하고 (있음>수정해주고, 없음>다시 없다고 알림창 뛰우며 index로 가고)
    //404랑, 405, 500 에러 exception도 해주ㄱ

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


    /*@DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> removeUserbyId(@PathVariable(value = "userId") Long id) {
        userService.removeUserbyId(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getUsername")
    public String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }*/
}
