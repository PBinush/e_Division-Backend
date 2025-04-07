package edu.e_g.controller;

import edu.e_g.dto.Person;
import edu.e_g.dto.User;
import edu.e_g.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    final UserService userService;

//    @PostMapping("/save")
//    public ResponseEntity<User> saveUser(@RequestBody User user){
//        try {
//            User newUser = userService.addUser(user);
//            return new ResponseEntity<>(newUser, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/save")
    public ResponseEntity<String> addUser(@Valid @RequestBody User user, HttpServletRequest request) {
        if(userService.addUser(user)) {
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | Add Person detail: {}", os, user);
            return ResponseEntity.ok("person added successful");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't added person");
        }

    }

//user login encript becript backend code controller/service
}
