package com.example.demo.Controllers;

import com.example.demo.DTO.LoginResponseDTO;
import com.example.demo.DTO.UpdatePassDTO;
import com.example.demo.DTO.UsersDTO;
import com.example.demo.Models.Users;
import com.example.demo.Responses.UserResponse;
import com.example.demo.Services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UsersDTO usersDTO,
                                      BindingResult result){
        try {
            if (result.hasErrors()) {
                List<String> errorMessage = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessage);
            }
            if(!usersDTO.getPassword().equals(usersDTO.getRetypePass())){
                return ResponseEntity.badRequest().body("Password and retypepass not same");
            }
            Users users = userService.createUser(usersDTO);
            return ResponseEntity.ok(users);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UsersDTO usersDTO) {
        try {
            LoginResponseDTO responseDTO = userService.login(usersDTO.getPhoneNumber(), usersDTO.getPassword());
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Login failed: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_User')")
    public ResponseEntity<?> updatePass(@PathVariable("id") Long id, @Valid @RequestBody UpdatePassDTO updatePassDTO){
        try {
            if(!updatePassDTO.getNewPass().equals(updatePassDTO.getRetypePass())){
                return ResponseEntity.badRequest().body("New password and retype password not same");
            }
            Users users = userService.updatePass(updatePassDTO, id);
            return ResponseEntity.ok(users);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public ResponseEntity<List<UserResponse>> getAllUserByRoleUser(){
        List<UserResponse> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/active/{id}")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public ResponseEntity<?> updateActive(@PathVariable("id") Long id, @Valid @RequestBody UserResponse userResponse) {
        try {
            Users users = userService.updateActive(userResponse, id);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}