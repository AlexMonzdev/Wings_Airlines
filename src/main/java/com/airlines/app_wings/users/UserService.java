package com.airlines.app_wings.users;

import com.airlines.app_wings.roles.Role;
import com.airlines.app_wings.roles.RoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUserRole(Long userId, String roleName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Optional<Role> role = roleService.findByRole(roleName);
        if (role.isEmpty()) {
            throw new RuntimeException("Role not found: " + roleName);
        }

        user.getRoles().clear(); // Remueve roles previos
        user.getRoles().add(role.get()); // Agrega el nuevo rol
        return userRepository.save(user);
    }


}
