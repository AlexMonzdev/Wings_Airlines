package com.airlines.app_wings.users;


import com.airlines.app_wings.roles.Role;
import com.airlines.app_wings.roles.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        User registeredUser = userService.registerUser(userRequestDto);
        return ResponseEntity.ok(registeredUser);
    }

//    @PutMapping("/{id}/role")
//    public ResponseEntity<User> updateUserRole(@PathVariable Long id, @RequestParam String roleName) {
//        User updatedUser = userService.updateUserRole(id, roleName);
//        return ResponseEntity.ok(updatedUser);
//    }


}
