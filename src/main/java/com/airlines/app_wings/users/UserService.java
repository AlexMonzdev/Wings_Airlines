package com.airlines.app_wings.users;

import com.airlines.app_wings.roles.Role;
import com.airlines.app_wings.roles.RoleService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(UserRequestDto userRequestDto) {
        Optional<Role> clientRole = roleService.findByRole("ROLE_CUSTOMER");
        if (clientRole.isEmpty()) {
            throw new RuntimeException("Role CUSTOMER not found");
        }

        // Crear y mapear un nuevo usuario
        User user = new User();
        user.setUsername(userRequestDto.user()); // Asumiendo que el campo "user" es el email
        user.setPassword(passwordEncoder.encode(userRequestDto.password())); // Encripta la contraseña
        user.getRoles().add(clientRole.get());

        return userRepository.save(user);
    }

//    public User updateUserRole(Long userId, String roleName) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Optional<Role> role = roleService.findByRole(roleName);
//        if (role.isEmpty()) {
//            throw new RuntimeException("Role not found: " + roleName);
//        }
//
//        user.getRoles().clear(); // Remueve roles previos
//        user.getRoles().add(role.get()); // Agrega el nuevo rol
//        return userRepository.save(user);
//    }


}
