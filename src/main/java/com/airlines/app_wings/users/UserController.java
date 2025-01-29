package com.airlines.app_wings.users;


import com.airlines.app_wings.roles.Role;
import com.airlines.app_wings.roles.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        Optional<Role> clientRole = roleService.findByRole("CUSTOMER");
        if (clientRole.isEmpty()) {
            throw new RuntimeException("Role CUSTOMER not found");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(clientRole.get());
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/{id}/role")
    public ResponseEntity<User> updateUserRole(@PathVariable Long id, @RequestParam String roleName) {
        User updatedUser = userService.updateUserRole(id, roleName);
        return ResponseEntity.ok(updatedUser);
    }


}
