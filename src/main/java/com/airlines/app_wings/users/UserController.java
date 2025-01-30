package com.airlines.app_wings.users;


import com.airlines.app_wings.roles.Role;
import com.airlines.app_wings.roles.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping("/login")
    public ResponseEntity<Map<String, String>> login() {
        SecurityContext contextHolder = SecurityContextHolder.getContext();
        Authentication auth = contextHolder.getAuthentication();
        Map<String,String> json = new HashMap<>();
        json.put("message", "Logged");
        json.put("username", auth.getName());
        json.put("roles", auth.getAuthorities().iterator().next().toString());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
    }

//    @PutMapping("/{id}/role")
//    public ResponseEntity<User> updateUserRole(@PathVariable Long id, @RequestParam String roleName) {
//        User updatedUser = userService.updateUserRole(id, roleName);
//        return ResponseEntity.ok(updatedUser);
//    }


}
