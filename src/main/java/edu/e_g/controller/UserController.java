package edu.e_g.controller;

import edu.e_g.dto.User;
import edu.e_g.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody @Valid User user) {
        return userService.saveUser(user) ?
                ResponseEntity.ok("User saved successfully") :
                ResponseEntity.badRequest().body("Failed to save user");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody @Valid User user) {
        return userService.updateUser(user) ?
                ResponseEntity.ok("User update successfully") :
                ResponseEntity.badRequest().body("Failed to update user");
    }

    @GetMapping("/getByEmail")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        try {
            User userByEmail = userService.getUserByEmail(email);
            return ResponseEntity.ok(userByEmail);
        }catch (Exception e){
            log.error("user not found");
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
 }
